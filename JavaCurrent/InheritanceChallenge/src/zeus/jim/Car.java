package zeus.jim;

public class Car extends Vehicle {

    private int NumberOfWheels;
    private boolean isAutomatic;
    private int speed;

    public Car(int numberOfWheels, boolean isAutomatic, int speed) {
        super("land");
        NumberOfWheels = numberOfWheels;
        this.isAutomatic = isAutomatic;
        this.speed = speed;
    }
}
