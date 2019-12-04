package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setFirstNumber(25);
        calculator.setSecondNumber(5);
        System.out.println(calculator.getAdditionResult());

    }
}
