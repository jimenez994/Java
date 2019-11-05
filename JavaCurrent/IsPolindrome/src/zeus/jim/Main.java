package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(isPolindrome(454));
    }

    public static boolean isPolindrome(int number){
        if(number < 0){
            number = number * -1;
        }
        System.out.println(number);
        int reverse = 0;
        int lastNumber = 0;
        int orginal = number;
        while(number != 0 || number > 0){
            System.out.println(lastNumber);
            lastNumber = number % 10;
            reverse = (reverse * 10) + lastNumber;
            number /= 10;
        }
        System.out.println(reverse +" " + orginal);
        return orginal == reverse;

    }
}
