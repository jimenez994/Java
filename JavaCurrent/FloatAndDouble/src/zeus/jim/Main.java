package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello world");
        float myMinFloatValue = Float.MIN_VALUE;
        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Float minimun value = " + myMinFloatValue);
        System.out.println("Float max value = " + myMaxFloatValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double minimun value = " + myMinDoubleValue);
        System.out.println("Double max value = " + myMaxDoubleValue);

        int intValue = 5/2;
        float floatValue = (float) 3.43/3;
        double doubleValue = 3.45d/3d;

        System.out.println("This is a int Value = " + intValue);
        System.out.println("This is a float Value = " + floatValue);
        System.out.println("This is a double Value = " + doubleValue);

//        A little challenge
        int poundVal = 200;
        double kilogramsVal = poundVal*0.45359237;

        System.out.println(poundVal + " pound is " + kilogramsVal + " in kilograms");

    }
}
