package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(hasSameLastDigit(23,23,55));
    }

    public static boolean hasSameLastDigit(int num1, int num2 , int num3){
        if(isValid(num1) && isValid(num2) && isValid(num3)){
            int a = num1 % 10;
            int b = num2 % 10;
            int c = num3 %10;
//            if(a == b || a == c || b == c ){
//                return true;
//            }
            return a == b || a == c || b == c;
        }
        return false;
    }
    public static boolean isValid(int number){
        if(number >= 10 && number <= 1000){
            return true;
        }
        return false;
    }
}
