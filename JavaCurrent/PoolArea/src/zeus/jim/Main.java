package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Rectangle rec1 = new Rectangle(5,10);
        System.out.println(rec1.getArea());
        System.out.println(rec1.getLength());
        System.out.println(rec1.getWidth());
        Cuboid cub1 = new Cuboid(5,10,5);
        System.out.println(cub1.getHeight());
        System.out.println(cub1.getVolume());
        System.out.println(cub1.getLength());
     }
}
