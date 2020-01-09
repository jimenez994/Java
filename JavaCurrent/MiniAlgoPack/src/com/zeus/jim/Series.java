package com.zeus.jim;

public class Series {

    static int nSum(int n){
        int sum = 0;
        for (int i =0 ; i < n; n--){
            sum+=n;
        }
        return sum;
    }

    static int factorial(int n){
        int result = 1;
        if(n <= 0){
            result = 0;
        }
        for (int i =1 ; i <= n; i++){
            result*=i;
        }
        return result;
    }

    static int fibonacci(int n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
