package zeus.jim;

public class Carpet {

    private double cost;

    public Carpet(double cost) {
        cost = (cost < 0)? 0: cost;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}
