package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Light roomLights = new Light(4,"regular",true);
        Bed myBed = new Bed(new Dimensions(8,6),"purple", "grey");
        Door myDoor = new Door(new Dimensions(6,4),"white","wood");
        AWindow myWindow = new AWindow("aluminium", "residential", new Dimensions(4,6),"white");
        Room myRoom = new Room(myWindow, myDoor, myBed , roomLights);

        myRoom.LightsOn();
        System.out.println(myRoom.getLight().getOn());
    }
}
