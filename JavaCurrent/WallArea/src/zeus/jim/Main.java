package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Wall f1w = new Wall(3,4);
        System.out.println(f1w.getArea());

        Wall f2w = new Wall(0,4);
        System.out.println(f2w.getArea());
    }
}
