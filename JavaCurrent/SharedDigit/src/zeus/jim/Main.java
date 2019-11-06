package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(hasSharedDigit(22,13));
    }

    public static boolean hasSharedDigit(int number1, int number2){
        if(number1 >= 10 && number1 <= 99 && number2 >= 10 && number2 <= 99){

           if(number1 % 10 == number2 % 10){
               return true;
           }else if (number1 % 10 == number2 /10){
               return true;
           }else if(number1 / 10 == number2 % 10){
               return true;
           }else if(number1 /10 == number2 /10 ){
               return true;
           }else{
               return false;
           }
        }
        return false;
    }
}
