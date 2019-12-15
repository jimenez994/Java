package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Cylinder C1 = new Cylinder(5.55,7.25);
        System.out.println(C1.getArea() + " " + C1.getHeight());

        Circle ed = new Circle(3.75);
        System.out.println(ed.getRadius());
        System.out.println(ed.getArea());
        System.out.println(C1.getVolume());

    }
}
