package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(isEven(4));
        numberOfEvenNumbers(2,49);
    }
    
    public static int numberOfEvenNumbers(int start, int end){
        if(start <= end && start > 0){
            int i = start;
            int count = 0;
            while (end > i){
                i++;
                if(!isEven(i)){
                    continue;
                }
                count++;
                System.out.println("This is a even number = " + i);
                if(count >= 5){
                    break;
                }
            }
            System.out.println("Found " + count + " even numbers in " + start + " - " + end);
            return count;
        }
        return -1;
    }

    public static boolean isEven(int number){
        if(number % 2 == 0){
            return true;
        }
        return false;
    }
}
