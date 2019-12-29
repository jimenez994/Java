package zeus.jim;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ISaveable player = new Player("Jonny", 34, "Gun");
        saveObject(player);
        System.out.println(((Player) player).toString());

        ISaveable monster = new Moster("sss","max", 32);
        saveObject(monster);
        System.out.println(((Moster) monster).toString());
    }

    public static void saveObject(ISaveable objectToSave){
        for (int i =0 ; i < objectToSave.write().size(); i++){
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }
    public static void loadObject(ISaveable objectToLoad){
        ArrayList<String> values ;
    }
}
