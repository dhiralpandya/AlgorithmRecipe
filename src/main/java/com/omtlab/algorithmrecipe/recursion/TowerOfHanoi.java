package com.omtlab.algorithmrecipe.recursion;

import java.util.Stack;

public class TowerOfHanoi {

    // GOOD explanation : https://www.youtube.com/watch?v=Ajy8XweC3L8
    // Lets assume we have only two rings. 1 and 2 (1 smaller, 2 bigger)
    // We just have to focus on three steps
    //STEP 1.  Move smaller ring to Second Tower (towerOne -> towerTwo)
    //STEP 2. Move bigger ring to Third tower (towerOne -> towerThree)
    //STEP 3. Move smaller ring to Third tower (towerTwo -> towerThree)
    public static void executeAlgorithm(String args[]) {
        Stack<Integer> towerOne = new Stack<>();

        for (int i = 5; i > 0; i--) {
            towerOne.push(i);
        }

        Stack<Integer> towerTwo = new Stack<>();
        Stack<Integer> towerThree = new Stack<>();

        towerOfHanoi(towerOne.size(), towerOne, towerTwo, towerThree);

        while (!towerThree.isEmpty()) {
            System.out.println(towerThree.pop());
        }

    }

    public static void towerOfHanoi(int n, Stack<Integer> towerOne, Stack<Integer> towerTwo,
                                    Stack<Integer> towerThree) {

        if (n > 0) {
            towerOfHanoi(n - 1, towerOne, towerThree, towerTwo);
            towerThree.push(towerOne.pop());
            towerOfHanoi(n - 1, towerTwo, towerOne, towerThree);
        }

    }
}
