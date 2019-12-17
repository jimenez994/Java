package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Ferrari myF = new Ferrari("Yellow");
        myF.accelerate();
        myF.startEngine();
        System.out.println(myF.getCylinders());

        Toyota car2 = new Toyota(4,2,4);
        car2.accelerate();
        car2.startEngine();

        BMW car3 = new BMW(8,4,4);
        car3.startEngine();
        car3.accelerate();

    }
}
