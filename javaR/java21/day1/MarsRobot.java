/**
 * MarsRobot
 */
public class MarsRobot {
    String status;
    int speed;
    float temperature;

    void checkTemperature(){
        if(temperature < -80) {
            status = "returning Home";
            speed = 5;
        }
    }
    void showSttributes(){
        System.out.println("Status: "+ status);
        System.out.println("Speed: "+ speed);
        System.out.println("Temperature: "+ temperature);
    }
}