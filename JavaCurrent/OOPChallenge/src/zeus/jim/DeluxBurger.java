package zeus.jim;

public class DeluxBurger extends BasicBurger {
    private boolean hasDrink;
    private boolean hasChips;

    public DeluxBurger(String bread, String meat, double price) {
        super(bread, meat, price);
        this.hasDrink = true;
        this.hasChips = true;
        addLettuce();
        addOnions();
        addPickles();
        addTomato();
    }

}
