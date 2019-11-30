package zeus.jim;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        inputThenPrintSumAndAverage();
    }
    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        while (true){
            if(scanner.hasNextInt()){
                int number = scanner.nextInt();
                sum+= number;
                count++;
            }else{
                break;
            }
        }
        scanner.close();
        System.out.println("SUM = " + sum + " AVG = " + Math.round((double)sum/count));
    }
}
