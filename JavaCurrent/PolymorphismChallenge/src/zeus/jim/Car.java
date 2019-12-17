package zeus.jim;

public class Car {
    private boolean engine;
    private int cylinders;
    private int wheels = 4;
    private int doors;
    private int seats;

    public Car(boolean engine, int cylinders, int doors, int seats) {
        this.engine = engine;
        this.cylinders = (cylinders > 0 && cylinders < 16)? cylinders: 1;
        this.doors = (doors >= 0 && doors < 16) ? doors : 0;
        this.seats = (seats > 0 && seats < 16)? seats: 1;
    }

    public void startEngine(){
        System.out.println("Starring Engine");
    }

    public void accelerate(){
        System.out.println("Car Accelerating");
    }

    public void brake(){
        System.out.println("Using break, Car is now slowing down");
    }

    public boolean isEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public int getDoors() {
        return doors;
    }

    public int getSeats() {
        return seats;
    }
}
