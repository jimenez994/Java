package com.zeus.jim;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<>();
    private static Map<String, String> compass = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExists = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExists));
        
        tempExists = new HashMap<>();
        tempExists.put("N", 5);
        tempExists.put("E", 3);
        tempExists.put("S", 4);
        tempExists.put("W", 2);
        locations.put(1, new Location(1, "You are on the road", tempExists));

        tempExists = new HashMap<>();
        tempExists.put("N", 5);
        locations.put(2, new Location(2, "You are at top o fa hill", tempExists));

        tempExists = new HashMap<>();
        tempExists.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building", tempExists));

        tempExists = new HashMap<>();
        tempExists.put("N", 1);
        tempExists.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley", tempExists));

        tempExists = new HashMap<>();
        tempExists.put("W", 2);
        tempExists.put("S", 1);
        locations.put(5, new Location(5, "You are in th a forest", tempExists));

        compass.put("NORTH", "N");
        compass.put("EAST", "E");
        compass.put("SOUTH", "S");
        compass.put("WEST", "W");
        compass.put("QUIT", "Q");

        int loc = 1;
        while (true){
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0){
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exists: ");

            exits.forEach((direction, location) ->
                System.out.print(direction +", ")
            );

            System.out.println();

            String direction= scanner.nextLine().toUpperCase();
            if(direction.length() > 1){
                String[] userWords = direction.split(" ");
                for (String word: userWords) {
                    if(exits.containsKey(compass.get(word))){
                        direction = compass.get(word);
                        break;
                    }
                }
            }
            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            }else{
                System.out.println("Sorry you can't go that direction");
            }
        }
    }
}
