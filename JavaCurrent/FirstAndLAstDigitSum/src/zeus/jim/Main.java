package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(firstAndLastDigitSum(0));

    }
    public static int firstAndLastDigitSum(int number){
        if(number >= 0){
            int lastDigit = number % 10;
            int firstDigit = 0;
            while (number > 0 ){
                firstDigit = number % 10;
                number = number /10;
            }
            return firstDigit + lastDigit;
        }
        return -1;
    }
}
