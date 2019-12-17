package zeus.jim;

public class Toyota extends Car {
    public Toyota(int cylinders, int doors, int seats) {
        super(true, cylinders, doors, seats);
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating nice and slow");
    }

}
