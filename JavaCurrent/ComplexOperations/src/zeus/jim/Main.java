package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ComplexNumber one = new ComplexNumber(1,1);
        ComplexNumber number = new ComplexNumber(2.5,-1.5);
        one.add(1,1);
        System.out.println("real Add " + one.getReal());
        System.out.println("Image add " + one.getImaginary());
        one.subtract(number);
        System.out.println("r add " + one.getReal());
        System.out.println("i add " + one.getImaginary());
        number.subtract(one);
        System.out.println("r add " + number.getReal());
        System.out.println("i add " + number.getImaginary());

    }
}
