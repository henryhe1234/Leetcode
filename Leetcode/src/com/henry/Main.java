package com.henry;

import org.w3c.dom.ls.LSOutput;

import java.util.MissingFormatArgumentException;

public class Main {

    public static void main(String[] args) {
       String s = "28.12.2013";
       String[] str = s.split("\\.");
//       print(str);
        int[] A = {0,1,2,3,4,5};
        System.out.println(A[5/2]);

    }
    public static void print(String arr[]){
        for(String ss : arr){
            System.out.println(ss);
        }
    }



}
