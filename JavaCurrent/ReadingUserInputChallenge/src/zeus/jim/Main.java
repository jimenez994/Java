package zeus.jim;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        int sum = 0;
        System.out.println("Hello there, please input 10 different numbers");
        while (count <= 10){
            System.out.println("Enter number #" + count);
            boolean isInt = scanner.hasNextInt();
            if(isInt){
                int number = scanner.nextInt();
                sum+=number;
                count++;
            }else{
                System.out.println("Sorry that was an invalid input");
            }
            scanner.nextLine();//"Handles the end of the next line"
        }
        scanner.close();
        System.out.println(" Your total sum is "+sum);
    }

}
