package zeus.jim.addition;

public class Car {
    private int doors;
    private int year;
    private String model;
    private String color;

    public Car(){};
    public Car(String model, String color, int year, int doors){
        setDoors(doors);
    }
    public void setDoors(int doors){
        this.doors = doors;
    }
    public int getDoors() {
        return this.doors;
    }
}
