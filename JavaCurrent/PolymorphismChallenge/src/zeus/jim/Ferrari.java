package zeus.jim;

public class Ferrari extends Car {
    private String color;
    public Ferrari(String color) {
        super(true, 12, 2, 2);
    }

    @Override
    public void accelerate() {
        System.out.println("Accelerating Ferrari, 0-60 in 3.2 secs ");
    }

    public void startEngine(){
        System.out.println("Ferrari ON laud rarr");
    }
}
