package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Point first  = new Point(6,5);
        System.out.println(first.distance());
        Point second = new Point(3,1);
        System.out.println(first.distance(2,2));
        System.out.println(first.distance(second));
    }
}
