package com.zeus.jim;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
//      Currently temp still holds earth
//        moon is being added to earth here
        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(temp.getName(), temp);
        temp.addSatellite(tempMoon);

        temp = new Planet("Earth", 35);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets: ");
        for (HeavenlyBody planet: planets) {
            System.out.println(planet);
            HeavenlyBody body = solarSystem.get(planet.getName());
            for (HeavenlyBody moon: body.getSatellites()) {
                System.out.println("\t"+ "\t" + moon.getName());
            }
        }

        HeavenlyBody earth1 = new Planet("earth", 365);
        HeavenlyBody earth2 = new Planet("earth", 365);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
        System.out.println(earth1.equals(tempMoon));

    }
}
