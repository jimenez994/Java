package zeus.jim;

public class Wall {
    private double width;
    private double height;

    public Wall(){
        this.height = 0;
        this.width = 0;
    }

    public Wall(double width, double height) {
        width = (width < 0)? 0: width;
//        if(width < 0){
//            width = 0;
//        }
        height = (height < 0 ) ? 0 : height;
//        if(height < 0){
//            height = 0;
//        }
        this.height = height;
        this.width = width;
    }

    public double getArea(){
        return this.height * this.width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width < 0){
            this.width = 0;
        }else{
            this.width = width;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height < 0){
            this.height = 0;
        }else{
            this.height = height;
        }
    }
}
