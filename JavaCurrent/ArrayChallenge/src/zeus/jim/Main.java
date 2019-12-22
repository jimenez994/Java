package zeus.jim;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        System.out.println("Enter your numbers to sort: ");
        int[] inputNums = getIntegers();
        printArr(inputNums);
        System.out.println("This is your sorted array;");
        printArr(sortDecs(inputNums));


    }

    public static int[] getIntegers(){
        int[] inputNums = new int[5];
        for (int num =0; num < inputNums.length; num++) {
            System.out.println("# " + (num+1)+ "/5");
            inputNums[num] = scanner.nextInt();
        }
        return inputNums;
    }

    public static void printArr(int[] intArray){
        String arrayInt = "[";
        for (int num = 0; num < intArray.length; num++) {
            if(num == intArray.length-1){
                arrayInt+= (intArray[num]+ "]");
            }else{
                arrayInt+= (intArray[num]+", ");
            }
        }
        System.out.println("Your array is --> "+arrayInt);
    }

    public static int[] sortDecs(int [] intArr){
        for (int i = 0; i < intArr.length; i++){
            for (int e = 1; e < intArr.length-i; e++){
                if(intArr[e] > intArr[e-1]){
                    int holder = intArr[e];
                    intArr[e] = intArr[e-1];
                    intArr[e-1] = holder;
                }
            }
        }
        return intArr;
    }
}
