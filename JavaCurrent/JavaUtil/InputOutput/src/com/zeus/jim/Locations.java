package com.zeus.jim;

import jdk.jshell.execution.LoaderDelegate;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        try(FileWriter locFile = new FileWriter("locations.txt");
            FileWriter dirFile = new FileWriter("directions.txt")){
            for (Location location: locations.values()) {
                locFile.write(location.getLocationID() + ", " + location.getDescription() + "\n");
                for (String direction: location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }
//        FileWriter locFile  = null;
//        try{
//            locFile = new FileWriter("locations.txt");
//            for (Location location: locations.values()) {
//                locFile.write(location.getLocationID() + ", " + location.getDescription() + "\n");
//            }
//        }catch (IOException e) {
//            System.out.println("In catch block");
//            e.printStackTrace();
//        }finally {
//            System.out.println("in finally block");
//            try{
//                if(locFile != null){
//                    System.out.println("Attempting to close locFile");
//                    locFile.close();
//                }
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
    }

    static {
        Scanner scanner = null;
        try{
            scanner = new Scanner(new FileReader("locations.txt"));
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()){
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Importing: " + loc + " , " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(scanner != null){
                scanner.close();
            }
        }

//        Map<String, Integer> tempExists = new HashMap<>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExists));
//
//        tempExists = new HashMap<>();
//        tempExists.put("N", 5);
//        tempExists.put("E", 3);
//        tempExists.put("S", 4);
//        tempExists.put("W", 2);
//        locations.put(1, new Location(1, "You are on the road", tempExists));
//
//        tempExists = new HashMap<>();
//        tempExists.put("N", 5);
//        locations.put(2, new Location(2, "You are at top o fa hill", tempExists));
//
//        tempExists = new HashMap<>();
//        tempExists.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building", tempExists));
//
//        tempExists = new HashMap<>();
//        tempExists.put("N", 1);
//        tempExists.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley", tempExists));
//
//        tempExists = new HashMap<>();
//        tempExists.put("W", 2);
//        tempExists.put("S", 1);
//        locations.put(5, new Location(5, "You are in th a forest", tempExists));
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
