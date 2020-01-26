package com.zeus.jim;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try{
            int result = divide();
            System.out.println(result);
        }catch (ArithmeticException e){
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down");
        }
    }

    public static int divide(){
        int x, y;
        try {
            x = getInt();
            y = getInt();
        }catch (NoSuchElementException e){
            throw new ArithmeticException("No suitable input");
        }
        System.out.println("x is " + x + " , y is " + y);
        try {
            return x/y;
        }catch (ArithmeticException e){
            throw new ArithmeticException("attempt to divide by zero");
        }
    }

    public static int getInt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input an integer");
        while (true){
            try {
                return scanner.nextInt();
            }catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Please enter a number");
            }
        }
    }
}
