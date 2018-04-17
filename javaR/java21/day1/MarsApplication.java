/**
 * MarsApplication
 */
public class MarsApplication {

    public static void main(String[] args){
        MarsRobot spirit = new MarsRobot();
        spirit.speed = 2;
        spirit.status = "Exploring";
        spirit.temperature = -90;
        spirit.showSttributes();
        spirit.checkTemperature();
        spirit.showSttributes();
    }
}