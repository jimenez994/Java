package com.zeus.jim;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88, HeavenlyBody.BodyType.PLANET);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225, HeavenlyBody.BodyType.PLANET);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365, HeavenlyBody.BodyType.PLANET);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
//      Currently temp still holds earth
//        moon is being added to earth here
        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27, HeavenlyBody.BodyType.MOON);
        solarSystem.put(temp.getName(), temp);
        temp.addSatellite(tempMoon);

        temp = new HeavenlyBody("Earth", 35, HeavenlyBody.BodyType.PLANET);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets");
        for (HeavenlyBody planet: planets) {
            System.out.println("\t" + planet.getName() +" - orbital period: " + planet.getOrbitalPeriod());
            HeavenlyBody body = solarSystem.get(planet.getName());
            for (HeavenlyBody moon: body.getSatellites()) {
                System.out.println("\t"+ "\t" + moon.getName());
            }
        }

    }
}
