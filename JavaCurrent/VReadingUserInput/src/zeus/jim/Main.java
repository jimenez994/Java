package zeus.jim;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Are you good with math "+ name +"? yes or no ? ");
        String yesOrNo = scanner.nextLine();
        if(yesOrNo.toLowerCase().equals("yes")){
            System.out.println("Whats 25 + 47?");
            String answer = scanner.nextLine();
            if(Integer.parseInt(answer) == 72){
                System.out.println("Great job " + name + " that's correct");
                System.out.println("by the way how old are you?");
                int age = scanner.nextInt();
                System.out.println("That's cool that you are just " + age);
            }else{
                System.out.println("Sorry, the answer was 72");
            }
        }else if(yesOrNo.toLowerCase().equals("no")){
            System.out.println("Okay goodbye");
            scanner.close();
        }else{
            System.out.println("Sorry I don't understand");
        }
        scanner.close();
    }
}
