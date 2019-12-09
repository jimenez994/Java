package zeus.jim;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(13);
        person.setFirstName("joe");
        person.setLastName("lars");
        System.out.println(person.getFullName());
        System.out.println(person.isTeen());
    }
}
