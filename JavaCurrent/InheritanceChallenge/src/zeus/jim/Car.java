package zeus.jim;

public class Car extends Vehicle {

    private int NumberOfWheels;
    private boolean isAutomatic;
    private int speed;
    private String drive;
    private int numberOfDoors;
    private double weight;
    private String color;

    public Car(){};

    public Car( int numberOfWheels, boolean isAutomatic, int speed, String drive, int numberOfDoors, double weight, String color) {
        super("land");
        NumberOfWheels = numberOfWheels;
        this.isAutomatic = isAutomatic;
        this.speed = speed;
        this.drive = drive;
        this.numberOfDoors = numberOfDoors;
        this.weight = weight;
        this.color = color;
    }
}
