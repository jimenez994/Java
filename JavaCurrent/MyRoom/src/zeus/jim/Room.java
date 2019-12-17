package zeus.jim;

public class Room {
    private AWindow window;
    private Door door;
    private Bed bed;
    private Light light;

    public Room(AWindow window, Door door, Bed bed, Light light) {
        this.window = window;
        this.door = door;
        this.bed = bed;
        this.light = light;
    }

    public void LightsOn(){
        light.turnLightsOn();
    }

    public AWindow getWindow() {
        return window;
    }

    public Door getDoor() {
        return door;
    }

    public Bed getBed() {
        return bed;
    }

    public Light getLight() {
        return light;
    }
}
