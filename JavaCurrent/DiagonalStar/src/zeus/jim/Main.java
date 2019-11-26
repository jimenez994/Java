package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        printSquareStar(8);
    }
    public static void printSquareStar(int number){
        if (number < 5){
            System.out.println("Invalid Value");
        }else{
            for (int i = 0 ; number > i; i++){
                String singleLine = "";
                for (int e = 0 ; number > e; e++){
                    if(i == 0 || i == number-1 || e == 0 || e == number-1){
                        singleLine+="*";
                    }else if(i == e || number - i-1 == e){
                        singleLine+="*";
                    }else{
                        singleLine+=" ";
                    }
                }
                System.out.println(singleLine);
            }
        }
    }
}
