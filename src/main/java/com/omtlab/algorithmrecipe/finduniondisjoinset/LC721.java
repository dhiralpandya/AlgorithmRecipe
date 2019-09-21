package com.omtlab.algorithmrecipe.finduniondisjoinset;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 721. Accounts Merge
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a 
 * name, and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some 
 * email that is common to both accounts. Note that even if two accounts have the same name, they may belong to 
 * different people as people could have the same name. A person can have any number of accounts initially, but all 
 * of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the 
 * name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 *
 * Example 1:
 * Input: 
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", 
 * "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail
 * .com"], ["Mary", "mary@mail.com"]]
 * Explanation: 
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 
 * 'johnnybravo@mail.com'], 
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Note:
 *
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 */
public class LC721 {

    /**
     * Check this before jumping to solution 
     * https://github.com/dhiralpandya/learning/blob/master/Learn/src/com/omt/learn/geekforgeek/greedy/FindCycleInGraphUnionFindPathComp.java
     * https://www.youtube.com/watch?v=wU6udHRIkcc
     */
    /**
     * BELOW ALGO TAKES 584 ms in Leetcode, Check other method accountsMergePathComp for faster solution
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        DisJoinSet disJoinSet = new DisJoinSet();
        Map<String,String> emailNameMap = new HashMap<>(); 
        for(List<String> account:accounts){
            String name = account.get(0);
            
            disJoinSet.union(account.get(1),null);//First email
            emailNameMap.put(account.get(1),name);//Add name with first email
            
            for(int i = 2; i < account.size();i++){
                disJoinSet.union(account.get(1),account.get(i));//Merge everything into first email
                emailNameMap.put(account.get(i),name); //Add name attached to this email
            }
        }
        
        
        Map<String,List<String>> parentEmailMap = new HashMap<>();
        for(String email:emailNameMap.keySet()){
            parentEmailMap.computeIfAbsent(disJoinSet.find(email),l-> Lists.newArrayList()).add(email);
        }
        
        for(List<String> emails : parentEmailMap.values()){
            Collections.sort(emails);
            String name = emailNameMap.get(emails.get(0));
            emails.add(0,name);
        }
        
        return new ArrayList<>(parentEmailMap.values());
    }
    
    static class DisJoinSet{
        Map<String,String> emailParentSet = new HashMap<>();
        
        public String find(String email){
            //Here second check is to avoid stack over flow in case of cycle. 
            if(emailParentSet.get(email) == null || emailParentSet.get(email).equals(email)){
                return email;
            }
            return find(emailParentSet.get(email));
        }
        
        public void union(String email1, String email2){
            if(email2 == null){
                emailParentSet.put(find(email1), null); 
            } else {
                emailParentSet.put(find(email1), find(email2));   
            }
        }
    }



    /**
     * Check this before jumping to solution 
     * https://github.com/dhiralpandya/learning/blob/master/Learn/src/com/omt/learn/geekforgeek/greedy/FindCycleInGraphUnionFindPathComp.java
     * https://www.youtube.com/watch?v=wU6udHRIkcc
     */
    /**
     * BELOW ALGO TAKES 72 ms which is faster than [584 ms] above due to path compression
     * @param accounts
     * @return
     */
    public List<List<String>> accountsMergePathComp(List<List<String>> accounts) {

        DisJoinSetPathCompression disJoinSet = new DisJoinSetPathCompression();
        Map<String,String> emailNameMap = new HashMap<>();
        for(List<String> account:accounts){
            String name = account.get(0);

            disJoinSet.union(account.get(1),null);//First email
            emailNameMap.put(account.get(1),name);//Add name with first email

            for(int i = 2; i < account.size();i++){
                disJoinSet.union(account.get(1),account.get(i));//Merge everything into first email
                emailNameMap.put(account.get(i),name); //Add name attached to this email
            }
        }


        Map<String,List<String>> parentEmailMap = new HashMap<>();
        for(String email:emailNameMap.keySet()){
            parentEmailMap.computeIfAbsent(disJoinSet.findPathComp(email),l-> Lists.newArrayList()).add(email);
        }

        for(List<String> emails : parentEmailMap.values()){
            Collections.sort(emails);
            String name = emailNameMap.get(emails.get(0));
            emails.add(0,name);
        }

        return new ArrayList<>(parentEmailMap.values());
    }


    static class DisJoinSetPathCompression{
        Map<String,String> emailParentSet = new HashMap<>();

        public String findPathComp(String email){
            //Here second check is to avoid stack over flow in case of cycle. 
            if(emailParentSet.get(email) == null || emailParentSet.get(email).equals(email)){
                return email;
            }
            String outputEmail = findPathComp(emailParentSet.get(email));
            emailParentSet.put(email,outputEmail);
            return outputEmail;
        }

        public void union(String email1, String email2){
            if(email2 == null){
                emailParentSet.put(findPathComp(email1), null);
            } else {
                emailParentSet.put(findPathComp(email1), findPathComp(email2));
            }
        }
    }
}
