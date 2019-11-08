package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        printFactors(10);
    }

    public static void printFactors(int number){
        if(number < 1){
            System.out.println("Invalid Value");
        }else{
            int holder = 1;
            while (holder <= number){
                if(number % holder == 0){
                    System.out.println(holder);
                }
                holder++;
            }
        }
    }
}
