package zeus.jim;

public class BMW extends Car {
    public BMW( int cylinders, int doors, int seats) {
        super(true, cylinders, doors, seats);
    }

    @Override
    public void startEngine() {
        System.out.println("Turning on your BMW");
    }
}
