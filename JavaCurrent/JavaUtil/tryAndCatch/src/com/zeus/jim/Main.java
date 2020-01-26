package com.zeus.jim;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.println(divideEAFP(2,0));
//        arithmeticException error
//        System.out.println(divide(2,0));
        System.out.println(divideLBYL(2,0));
    }

    public static int divide(int num1, int num2){
        return num1 / num2;
    }

//    Look Before You Leave
    public static int divideLBYL(int num1, int num2 ){
        if(num2 <= 0){
            return 0;
        }else{
            return num1/ num2;
        }
    }

//    Easy to Ask for Forgiveness and Permission
    public static int divideEAFP(int num1, int num2){
        try {
            return num1 / num2;
        }catch (ArithmeticException e){
            return 0;
        }
    }
}
