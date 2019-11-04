package zeus.jim;

public class Main {

    public static void main(String[] args) {

//        primeNumbers();

//        System.out.println(isOdd(2));
        System.out.println(sumOdd(100,-1000));
    }
    public static void primeNumbers(){
        int sum = 0;
        int counter = 0;
        for (int i = 1; i <= 1000; i++){
            if(counter == 5){
                break;
            }
            if(i % 3 == 0 && i % 5 == 0){
                sum+= i;
                System.out.println("Found Number = "+i);
                counter++;
            }
        }
        System.out.println("Sum = "+sum);
    }

    public static boolean isOdd(int number){
        if(number > 0){
            if(number % 2 == 1){
                return true;
            }
        }
        return false;
    }

    public static int sumOdd(int start, int end){
        int sum = 0;
        if(end >= start && start > 0 ){
            for (int i = start ; i <= end ; i++){
                if(isOdd(i)){
                    sum += i;
                }
            }
            return sum;
        }
        return  -1;
    }
}
