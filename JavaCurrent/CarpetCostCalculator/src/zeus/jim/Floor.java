package zeus.jim;

public class Floor {
    private double width;
    private double length;

    public Floor(double width, double height) {
        width = (width < 0)? 0: width;
        height = (height< 0 )? 0: height;
        this.width = width;
        this.length = height;
    }

    public double getArea(){
        return this.length * this.width;
    }

}
