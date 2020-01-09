package org.zeus.game;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
    private String name;
    private int hitPoint;
    private String weapon;

    public Player(String name, int hitPoint, String weapon) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.weapon = "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "player{" +
                "name='" + name + '\'' +
                ", hitPoint=" + hitPoint +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0,this.name);
        values.add(1, ""+this.hitPoint);
        values.add(2, this.weapon);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size() > 0){
            this.name = savedValues.get(0);
            this.hitPoint = Integer.parseInt(savedValues.get(1));
            this.weapon = savedValues.get(2);
        }
    }
}
