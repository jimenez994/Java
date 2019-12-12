package zeus.jim;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void add(double real, double imaginary){
        this.real += real;
        this.imaginary+= imaginary;
    }
    public void add(ComplexNumber complexNum){
        this.real += complexNum.real;
        this.imaginary += complexNum.imaginary;
    }

    public void subtract(double real, double imaginary){
        this.real -= real;
        this.imaginary -= imaginary;
    }
    public void subtract(ComplexNumber complexNum){
        this.real -= complexNum.real;
        this.imaginary -= complexNum.imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
}
