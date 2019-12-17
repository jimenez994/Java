package zeus.jim;

public class HealthyBurger extends BasicBurger {

    private boolean hasCucumber =false;
    private boolean hasSpinach = false;

    public HealthyBurger(String meat, double price) {
        super("Brown Rye Bread Roll", meat, (price > .50 && price < 100)?price: 6.99);
        setName("Healthy Burger");
    }

    public void addCucumber(){
        if(!hasCucumber){
            hasCucumber = true;
            addToTotal(45, "cucumber");
            System.out.println("Cucumber added");
        }else{
            System.out.println("Cucumbers is already added");
        }
    }

    public void addSpinach(){
        if(!hasCucumber){
            hasSpinach = true;
            addToTotal(65, "spinach");
            System.out.println("Spinach added");
        }else{
            System.out.println("Spinach is already added");
        }
    }

    public boolean isHasCucumber() {
        return hasCucumber;
    }

    public boolean isHasSpinach() {
        return hasSpinach;
    }
}
