package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BasicBurger burger  = new BasicBurger("plain", "Chicken", 6.98);
        burger.addLettuce();
        burger.addOnions();
        System.out.println(burger.getPrice());

        DeluxBurger dekuxBurge = new DeluxBurger("premium", "meat", 8.99);
    }
}
