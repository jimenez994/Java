package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(digitSum(125));
    }
    public static int digitSum(int number){
        if(number >= 10){
            int sum = 0;
            while (number > 0){
                sum += number % 10;
                number = number /10;
            }
            return sum;
        }else if(number >= 0){
            return number;
        }else {
            return -1;
        }
    };
}
