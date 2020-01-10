package com.zeus.jim;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        X x = new X();
        System.out.println("Input you number here:");
        x.x(scanner.nextInt());
    }
}
