package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(getEvenDigitSum(123456789));
    }

    public static int getEvenDigitSum(int number){
        if(number >= 0 ){
            int sumOfEvennumbers = 0;
            while(number > 0){
                if( number % 2 == 0){
                    sumOfEvennumbers += number % 10;
                }
                number = number / 10;
            }
            return sumOfEvennumbers;
        }
        return -1;
    }


}
