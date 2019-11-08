package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(isPerfectNumber(100));
    }
    public static boolean isPerfectNumber(int number){
        if(number < 1){
            return false;
        }else{
            int num2  = number/2;
            int sum = 0;
            while(num2 > 0){
                if(number % num2 == 0){
                    sum += num2;
                }
                num2 --;
            }
            System.out.println(sum +" = " + number);
            if (sum == number) {

                return true;
            }else{
                return false;
            }
        }
    }
}
