package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(reverse(123));
    }
    public static void numberToWords(int number){
        if(number < 0){
            System.out.println("Invalid value");
        }
    }
    public static int reverse(int number){
        int originalNum = number;
        int newNum = 0;
        int holder = 0;
        boolean ifNegative = false;
        if (number < 0){
            ifNegative = true;
            originalNum *= (-1);
            System.out.println(newNum);
        }
        while (originalNum > 0){
            holder = (originalNum % 10);
            newNum *= 10;
            newNum += holder;
            originalNum = originalNum /10;
        }

        return ifNegative ? (newNum *= -1) : newNum;
    }
}
