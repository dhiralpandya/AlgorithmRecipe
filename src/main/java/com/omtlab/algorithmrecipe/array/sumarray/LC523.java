package com.omtlab.algorithmrecipe.array.sumarray;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. Continuous Subarray Sum
 * <p>
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a
 * continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an
 * integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * Example 2:
 * <p>
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 */
public class LC523 {
    /**
     * This is HARDEST Problem to solve, 
     *
     * his is one of those magics of remainder theorem :)
     *
     * (a+([ANY NUMBER]*x))%x is same as (a%x)
     *
     * Again : (a+(n*x))%x is same as (a%x)
     *
     * For e.g. in case of the array [23,2,6,4,7] the running sum is [23,25,31,35,42] and
     * the remainders are [5,1,1,5,0]. We got remainder 5 at index 0 and at index 3.
     * That means, in between these two indexes we must have
     * added a number which is multiple of the k. Hope this clarifies your doubt :)
     *
     *
     */

    /**
     * So brilliant, learned a lot. Let me "visualize" @compton_scatter 's strategy:
     *
     * Running sum from first element to index i : sum_i. If we mod k, it will be some format like : sum_i = k * x + 
     * modk_1
     * Running sum from first element to index j : sum_j. If we mod k, it will be some format like : sum_j = k * y + 
     * modk_2
     * If they have the same mod, which is modk_1 == modk_2, subtracting these two running sum we get the difference 
     * sum_i - sum_j = (x - y) * k = constant * k, and the difference is the sum of elements between index i and j, 
     * and the value is a multiple of k.
     */

    /**
     * A proof sketch:
     * Suppose sum_i represents the running sum starting from index 0 and ending at i,
     * once we find a mod that has been seen, say modk, we have:
     * current one: sum_i = m*k + modk
     * previous one: sum_j = n*k + modk
     * Thus,
     * sum_i - sum_j = (m - n) *k
     */

    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;

        /**
         * For e.g. in case of the array [23,2,6,4,7] 
         * the running sum is [23,25,31,35,42] and the remainders are [5,1,1,5,0]. 
         * We got remainder 5 at index 0 and at index 3. 
         * That means, in between these two indexes we must have 
         * added a number which is multiple of the k. Hope this clarifies your doubt :)
         */
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (k != 0) {
                sum %= k;
            }

            if (map.containsKey(sum) && i - map.get(sum) > 1) {//Here > 1 because we need sum of at least 2
                return true;
            }

            if (!map.containsKey(sum)) {//Only insert latest index
                // if key is missing 
                // because we dont want to override older keys with latest index
                map.put(sum, i);
            }

        }


        return false;
    }


    /**
     * what is inverse operations of modulus
     * Interesting question! I don't think the final answer will be what you 
     * want, but the thinking on the way there will be worth having gone 
     * through.
     *
     * You have probably learned about inverse functions, and know that not 
     * every function has an inverse. The same is true of inverse operations. 
     * The existence of an inverse is not "normal," but a very special 
     * situation. The reason you think of it as normal is that invertible 
     * operations are particularly useful, so we tend to use them and give 
     * them names. Among familiar operations, therefore, invertibility is 
     * common, though not by any means universal.
     *
     * Also, it's worth noting that not all operations are commutative, as 
     * addition and multiplication are. When an operation is not commutative, 
     * you have to be careful about order, and it turns out that there are 
     * two different kinds of inverse you can talk about. For addition, the 
     * inverse operation, subtraction, is defined by
     *
     *     (x + y) - y = x
     *
     *     (x - y) + y = x
     *
     * We can call subtraction the "right inverse" of x, since doing it on 
     * the right of an addition undoes that addition. (I'm not positive that 
     * this is a standard term in this context, but I think it's right.) If 
     * we try to make subtraction a "left inverse," we find that it doesn't 
     * quite work:
     *
     *     x - (x + y) = -y
     *
     *     x + (x - y) = -y
     *
     * That happens because subtraction is not commutative.
     *
     * You are asking about the "mod" (remainder) operation. Recall that this 
     * is defined by
     *
     *     x mod y = z  if x = ny + z for some integer n, and 0 <= z < y
     *
     * (I'll ignore questions that arise if x or y are negative.)
     *
     * Apparently you want a left inverse of the mod operation, which we'll 
     * call "*", that gives the divisor when you know the dividend and 
     * remainder, so that if
     *
     *     x mod y = z         e.g. 6 mod 2 = 0
     *
     * then
     *
     *     x * z = y           e.g. 6 * 0 = 2
     *
     * This can be written as
     *
     *     x mod (x * z) = x   e.g. 6 mod (6 * 0) = 0
     *
     *     x * (x mod y) = y   e.g. 6 * (6 mod 2) = 2
     *
     * The problem is that there is not just one divisor for a given dividend 
     * and remainder:
     *
     *     6 mod 1 = 0
     *
     *     6 mod 2 = 0
     *
     *     6 mod 3 = 0
     *
     *     6 mod 6 = 0
     *
     * Which of 1, 2, 3, and 6 should be the result of 6*0?
     *
     * The same sort of problem occurs with the "right inverse," which gives 
     * the dividend given the divisor and remainder:
     *
     *     (z ** y) mod y = z   e.g. (0 ** 2) mod 2 = 0
     *
     * and
     *
     *     (x mod y) ** y = x   e.g. (6 mod 2) ** 2 = 6
     *
     * This time, we see that
     *
     *     2 mod 2 = 0
     *
     *     4 mod 2 = 0
     *
     *     6 mod 2 = 0
     *
     * and so on, so there are many solutions to the equation
     *
     *     x mod 2 = 0
     *
     * and no one value to choose for 0 ** 2.
     *
     * Just as with functions, the fact that the "mod" operation takes 
     * multiple inputs to the same output makes an inverse operation 
     * impossible.
     *
     * However, just as we have an inverse function "square root" that 
     * inverts the square function _when we restrict the domain of the 
     * latter_, we can do the same here. It's not very useful, however. Note 
     * that
     *
     *     x mod y = x  when 0 <= x < y
     *
     * so if we restrict the function f(x) = x mod y to that domain, the mod 
     * function becomes the identity function f(x) = x. Therefore, the 
     * inverse operation is simple:
     *
     *     x ** y = x when 0 <= x < y
     *
     * What this does is to find ONE of many possible dividends that give the 
     * desired remainder, namely the remainder itself. Another approach would 
     * be to have a multivalued "function" that gives ALL possible dividends; 
     * this is
     *
     *     x ** y = x + ny, for any integer n
     *
     * It's a little more complicated to do this for your "*" operation. Here 
     * you would want to find either one, or all, divisors that leave the 
     * given remainder. Given that
     *
     *     x mod y = z
     *
     * we can express this as
     *
     *     x = ny + z for some integer n
     *
     * To solve for y, we get
     *
     *     y = (x-z)/n, for any integer n that divides (x-z)
     *
     * Therefore,
     *
     *     x * z = 1
     *
     * or
     *
     *     x * z = x - z
     *
     * or
     *
     *     x * z = smallest factor of x-z greater than 1
     *
     * are possible partial inverse operations that give ONE possible 
     * divisor; and
     *
     *     x * z = all divisors of x-z
     *
     * gives all possible answers. But that doesn't really give you what you 
     * wanted, does it? Defining the inverse doesn't help in actually doing 
     * it.
     *
     * You may be interested in these answers related to the mod function:
     *
     *    What is Modulus?
     *    http://mathforum.org/library/drmath/view/54363.html   
     *
     *    Mod Function and Negative Numbers
     *    http://mathforum.org/library/drmath/view/52343.html   
     *
     * This one, about inverse operations, is also worth reading:
     *
     *    Inventing an Operation to Solve x^x = y
     *    http://mathforum.org/library/drmath/view/54586.html   
     *
     * - Doctor Peterson, The Math Forum
     *   http://mathforum.org/dr.math/   
     */
}
