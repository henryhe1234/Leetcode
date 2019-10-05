package com.henry;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public int singleNumber(int[] nums){
        HashSet<Integer> sets = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            if(sets.contains(nums[i])){
                sets.remove(nums[i]);
            }else{
                sets.add(nums[i]);
            }
        }
        if(sets.size()>1){
            return -1;
        }
        return sets.iterator().next();
    }

    public int singleNumber1(int[] nums){
        for(int i =1;i<nums.length;i++){
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i =0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    public static boolean isAnagram1(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for(char c: s.toCharArray()){
            count[c-'a']++;
        }
        for(char c : t.toCharArray()){
            count[c-'a']--;
        }
        for(int i : count){
            if(i !=0){
                return false;
            }
        }
        return true;
    }
    public String defangIPaddr(String address){
        String[] str = address.split("\\.");
        return str[0] + "[.]" + str[1]+ "[.]" + str[2] + "[.]" + str[3];
    }
    public String defangIPaddr1(String address){
        StringBuilder str = new StringBuilder();
        for(int i =0;i<address.length();i++){
            if(address.charAt(i) == '.'){
                str.append("[.]");
            }else{
                str.append(address.charAt(i));
            }
        }
        return str.toString();
    }
    public int firstUniqChar(String s){
       int[] count = new int[26];
       for(int i=0;i<s.length();i++){
           count[s.charAt(i) -'a']++;
       }
       for(int i=0;i<s.length();i++){
           if(count[s.charAt(i) -'a'] ==1){
               return i;
           }
       }
       return -1;
    }
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int start = 0;
        for(int i =1;i<S.length();i++){
            if(i == S.length() || S.charAt(i) != S.charAt(start)){
                if(i-start >= 3){
                    ans.add(Arrays.asList(start,i-1));
                }
                start = i;
            }
        }
        return ans;

    }
    public boolean checkPerfectNumber(int num) {
        if(num <=1){
            return false;
        }
        int sum = 1;
        int mid = (int)Math.sqrt(num);
        for(int i =2;i<=mid;i++){
            if(num%i == 0){
                sum += i;
                sum += (num /i);
            }
        }
        return sum == num;
    }
}


