package zeus.jim;

import java.util.ArrayList;
import java.util.List;

public class Moster implements ISaveable {
    private String name;
    private String strength;
    private int hitPoint;

    public Moster(String name, String strength, int hitPoint) {
        this.name = name;
        this.strength = strength;
        this.hitPoint = hitPoint;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0,this.name);
        values.add(1,this.strength);
        values.add(2,""+ this.hitPoint);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {

    }

    @Override
    public String toString() {
        return "Moster{" +
                "name='" + name + '\'' +
                ", strength='" + strength + '\'' +
                ", hitPoint=" + hitPoint +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }
}
