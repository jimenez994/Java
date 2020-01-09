package com.zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(Series.fibonacci(5));
        System.out.println(Series.factorial(5));
        System.out.println(Series.nSum(5));

        for (int i = 0; i <=10; i++){
            System.out.println("Sum "+Series.nSum(i));
        }
        for (int i = 0; i <=10; i++){
            System.out.println("Factorial "+Series.factorial(i));
        }
        for (int i = 0; i <=10; i++){
            System.out.println("Fibonacci "+Series.fibonacci(i));
        }
    }
}
