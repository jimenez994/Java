package zeus.jim;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        System.out.println("Enter count:");
        int[] inputInts = readIntegers(scanner.nextInt());
        printInts(inputInts);
        System.out.println("your min is -> "+findMin(inputInts));

        scanner.close();
    }
    public static int[] readIntegers(int count){
        int[] myList = new int[count];
            for (int i = 0; i < count; i++){
                System.out.println("# " + (i+1) + "/" + count);
                myList[i]= scanner.nextInt();
            }
        return myList;
    }

    public static void printInts(int[] arrOfInts){
        for (int num: arrOfInts) {
            System.out.println(num);
        }
    }

    public static int findMin(int[] arrOfInts){
        int min = arrOfInts[0];
        for (int num: arrOfInts) {
            if(min > num){
                min = num;
            }
        }
        return min;
    }
}
