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
    public int numJewelsInStones(String J, String S) {
        int[] count = new int[52];
        int total = 0;
        for(int i=0;i<J.length();i++){
            count[J.charAt(i) -'A']++;
        }
        for(int i=0;i<S.length();i++){
            if(count[S.charAt(i) -'A'] !=0){
                total++;
            }
        }
        return total;
    }
    public ListNode middleNode(ListNode head){
        ListNode[] node = new ListNode[100];
        int i=0;
        while(head != null){
            node[i++] = head;
            head = head.next;
        }
        return node[i/2];
    }
    public ListNode middleNode1(ListNode head){//fast & slow pointer method
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }
    public ListNode reverseList(ListNode head){
        //Iterative approach
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public ListNode reverseList1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode baseNode = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return baseNode;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }else{
                dummy.next = l2;
                l2=l2.next;
            }
            dummy = dummy.next;
        }
        if(l1 != null){
            dummy.next = l1;
        }
        if(l2 != null){
            dummy.next = l2;
        }
        return head.next;
    }
    public int[] sortArrayByParity(int[] A) {
        int index = 0;
        int[] array = new int[A.length];
        for(int i=0;i<A.length;i++){
            if(A[i] %2 == 0){
                array[index++] = A[i];
            }
        }
        for(int i=0;i<A.length;i++){
            if(A[i] %2 !=0){
                array[index++] = A[i];
            }
        }
        return array;
    }
    public int[] sortArrayByParity1(int[] A) {
        for(int i=0,j=0;j<A.length;j++){
            if(A[j] %2 ==0){
                int temp = A[i];
                A[i++] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                count++;
                if(i==1 || nums[i-2] <= nums[i]){//
                    nums[i-1] = nums[i];
                }else{
                    nums[i] = nums[i-1];
                }


            }
        }
        return count<=1;
    }

}


