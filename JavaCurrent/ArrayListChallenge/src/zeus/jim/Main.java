package zeus.jim;

import javax.sound.midi.Soundbank;
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
                    phone.listContacts();
                    break;
                case 2:
                    System.out.println("Name:");
                    String name = scanner.next();
                    System.out.println("Phone Number:");
                    String phoneNum = scanner.next();
                    phone.add(name, phoneNum);
                    break;
                case 3:
                    System.out.println("Enter phone number:");
                    phone.searchByPhone(scanner.next());
                    break;
                case 4:
                    System.out.println("Enter name:");
                    phone.searchByName(scanner.next());
                    break;
                case 5:
                    System.out.println("Enter contact index you want to update");
                    int index = scanner.nextInt()-1;
                    System.out.println("Enter new name:");
                    String newName = scanner.next();
                    System.out.println("Enter new phone number:");
                    String newPhone = scanner.next();
                    phone.updateContact(index, newName,newPhone);
                    break;
                case 6:
                    System.out.println("Enter index you want to remove:");
                    phone.removeContact(scanner.nextInt()-1);
                    break;
                case 9:
                    showMenu();
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
        System.out.println("1  List contacts");
        System.out.println("2  Add new contact");
        System.out.println("3  Search contact by phone");
        System.out.println("4  Search contact by name");
        System.out.println("5  Update contact");
        System.out.println("6  Remove contact by index");
        System.out.println("9  Show menu");
        System.out.println("0  Quit");
    }
}
