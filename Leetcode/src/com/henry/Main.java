package com.henry;

import java.util.MissingFormatArgumentException;

public class Main {

    public static void main(String[] args) {
       String s = "28.12.2013";
       String[] str = s.split("\\.");
       print(str);


    }
    public static void print(String arr[]){
        for(String ss : arr){
            System.out.println(ss);
        }
    }


}
