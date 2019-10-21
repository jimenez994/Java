public class Hello {
    public static void main(String[] args){
        String firstName = "Jonathan";
        String lastName = "Jimenez";
        int age = (2+ 3) + (10 + 9);
        int firstN = 12;
        int secondN = 6;
        System.out.println(firstN + secondN + age);
        System.out.println("Hello, " + firstName +" " + lastName + " " + age);
        age = add(age);
        System.out.println(age);
    }
    public static int add(int in){
        System.out.println(in + 1);
        return in+1;
    }
}
