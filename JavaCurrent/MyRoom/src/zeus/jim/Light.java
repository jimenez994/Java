package zeus.jim;

public class Light {
    private int numberOfLights;
    private String size;
    private Boolean isLED;
    private Boolean isOn;

    public Light(int numberOfLights, String size, Boolean isLED) {
        this.numberOfLights = numberOfLights;
        this.size = size;
        this.isLED = isLED;
        this.isOn = false;
    }

    public void turnLightsOn(){
        this.isOn = true;
    }

    private int getNumberOfLights() {
        return numberOfLights;
    }

    private String getSize() {
        return size;
    }

    private Boolean getLED() {
        return isLED;
    }

    public Boolean getOn() {
        return isOn;
    }
}
