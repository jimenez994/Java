package zeus.jim;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello ");
        int min = 0;
        int max = 0;
        boolean first = true;
        while (true){
            System.out.println("Enter your number");
            if(scanner.hasNextInt()){
                int input = scanner.nextInt();
                if(first){
                    first = false;
                    min = input;
                    max = input;
                }else{
                    if(input > max){
                        max = input;
                    }else if(input < min){
                        min = input;
                    }
                }
            }else{
                String exitIn = scanner.nextLine();
                if(exitIn.toLowerCase().equals("exit")){
                    break;
                }else{
                    System.out.println("invalid input");
                }
            }
            System.out.println("Min = " + min + "  Max = " + max);
        }
        scanner.close();
    }
}
