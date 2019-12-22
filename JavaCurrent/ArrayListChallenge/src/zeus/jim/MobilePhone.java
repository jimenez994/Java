package zeus.jim;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    private String name;

    public MobilePhone(String name) {
        this.name = name;
    }

    public void add(String name, String phone){
        if(searchByName(name)){
            System.out.println("Contact already exists");
        }else{
            if(name.isEmpty() || phone.isEmpty()){
                System.out.println("Either name or phone number was empty");
            }else{
                Contact newContact = new Contact(name,phone);
                contacts.add(newContact);
                System.out.println(newContact.getName() +" has been added");
            }
        }
    }

    public void listContacts(){
        int count = 1;
        for (Contact contact: contacts) {
            System.out.println("---------- "+(count++)+" ----------");
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone: " + contact.getNumber());
            System.out.println("---------------------------");
        }
    }

    public boolean searchByPhone(String phone){
        for (Contact contact: contacts) {
            if(contact.getNumber().equals(phone)){
                System.out.println("Contact found");
                System.out.println("*******************");
                System.out.println("Name: " +contact.getName());
                System.out.println("Phone: " +contact.getNumber());
                System.out.println("*******************");
                return true;
            }
        }
        System.out.println("Contact not found");
        return false;
    }
    public boolean searchByName(String name){
        for (Contact contact: contacts) {
            if(contact.getName().equals(name)){
                System.out.println("Contact found");
                System.out.println("*******************");
                System.out.println("Name: " +contact.getName());
                System.out.println("Phone: " +contact.getNumber());
                System.out.println("*******************");
                return true;
            }
        }
        System.out.println("Contact not found");
        return false;
    }

    public void updateContact(int position, String name, String phone){
        Contact original = contacts.get(position);
        if(!original.getName().isEmpty()){
            if(!name.isEmpty() && !phone.isEmpty()){
                original.setName(name);
                original.setNumber(phone);
                System.out.println(name+ "Has been updated");
            }else{
                System.out.println("Name or Phone cannot be empty");
            }
        }else{
            System.out.println("Something went wrong");
        }
    }

    public void removeContact(int index){
        contacts.remove(index);
        System.out.println("Contact removed");
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public String getName() {
        return name;
    }
}
