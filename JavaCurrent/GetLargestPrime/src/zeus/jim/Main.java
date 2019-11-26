package zeus.jim;

public class Main {

    public static void main(String[] args) {
        System.out.println(getLargestPrime(217));
    }

    public static int getLargestPrime(int number){
        if(number > 1){
            int greatestPrime = 2;
            while (number > 2){
                if(number % greatestPrime == 0){
                    number = number / greatestPrime;
                }else{
                    greatestPrime++;
                }
            }
            return greatestPrime;
        }
        return -1;
    }


}