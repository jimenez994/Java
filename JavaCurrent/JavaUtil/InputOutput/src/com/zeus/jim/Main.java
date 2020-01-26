package com.zeus.jim;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Locations locations = new Locations();
    private static Map<String, String> compass = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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
