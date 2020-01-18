package com.zeus.jim;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyType bodyType;

    public enum BodyType  {
        MOON,
        PLANET,
        DWARF_PLANET,
        COMMENT,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public boolean addSatellite(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;
//        System.out.println("obj.getClass() is " + obj.getClass());
//        System.out.println("obj.getClass() is " + this.getClass());
//        if (obj == null || this.getClass() != obj.getClass()) return false;
//        String objName = ((HeavenlyBody) obj).getName();
//        return this.name.equals(objName);
        if(obj instanceof HeavenlyBody){
            HeavenlyBody theObj = (HeavenlyBody) obj;
            if (this.name.equals(theObj.getName())){
                return this.bodyType == theObj.getBodyType();
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
//        return Objects.hash(name, orbitalPeriod, satellites);
        System.out.println("hasCode called");
        return this.name.hashCode() + 57 + this.bodyType.hashCode();
    }

    @Override
    public String toString() {
        return this.name + " : " + this.bodyType + "  " + this.orbitalPeriod;
    }
}
