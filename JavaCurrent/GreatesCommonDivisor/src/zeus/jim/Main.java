package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(getGreatestCommonDivisor(81,153));
    }

    public static int getGreatestCommonDivisor(int num1, int num2){
        if(num1 >= 10 && num2 >= 10){
            int a = Math.max(num1, num2);
            int b = Math.min(num1, num2);
            if(a % b == 0){
                return b;
            }
            int c = b/2;
            while (c > 0){
                if(a % c == 0 && b % c == 0){
                    return c;
                }
                c--;
            }

        }
        return -1;
    }
}
