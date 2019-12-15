package zeus.jim;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        height = (height < 0)? 0: height;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
    public double getVolume(){
        return this.height * getArea();
    }
}
