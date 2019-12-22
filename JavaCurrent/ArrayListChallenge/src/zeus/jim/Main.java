package zeus.jim;

import java.util.Scanner;

public class Main {

    private static Scanner scanner =  new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        MobilePhone myPhone = new MobilePhone("Phone");
        showMenu();
        menu(myPhone);


    }

    public static void menu(MobilePhone phone){
        boolean isOn = true;
        while (isOn){
            switch (scanner.nextInt()){
                case 1:
                    System.out.println("Name:");
                    String name = scanner.next();
                    System.out.println("Phone Number:");
                    String phoneNum = scanner.next();
                    phone.add(name, phoneNum);
                    break;
                case 2:
                    phone.searchByPhone(scanner.next());
                    break;
                case 0:
                    isOn = false;
                    break;
                default:
                    System.out.println("Must be in this list");
                    break;
            }
        }
    }

    public static void showMenu(){
        System.out.println("----Menu----");
        System.out.println("1  Add new contact");
        System.out.println("2  Search by phone");
        System.out.println("0  Quit");
    }
}
