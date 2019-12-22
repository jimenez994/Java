package zeus.jim;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    private String name;

    public MobilePhone(String name) {
        this.name = name;
    }

    public Contact add(String name, String phone){
        Contact newContact = new Contact(name,phone);
        contacts.add(newContact);
        System.out.println(newContact.getName() +" has been added");
        return newContact;
    }

    public void listContacs(){

    }

    public boolean searchByPhone(String phone){
        for (Contact contact: contacts) {
            if(contact.getNumber().equals(phone)){
                System.out.println("Phone number found");
                return true;
            }
        }
        System.out.println("Phone number not found");
        return false;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public String getName() {
        return name;
    }
}
