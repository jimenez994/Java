public class Hello {
    public static void main(String[] args){
        String firstName = "Jonathan";
        String lastName = "Jimenez";
        int age = 24;
        System.out.println("Hello, " + firstName +" " + lastName + " " + age);
        System.out.println(age);


        age = add(age);
    }
    public static int add(int in){
        System.out.println(in + 1);
        return in+1;
    }
}
