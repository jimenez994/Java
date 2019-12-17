package zeus.jim;

public class BasicBurger {
    private String bread;
    private String meat;
    private boolean hasLettuce = false;
    private boolean hasTomato = false;
    private boolean hasPickles = false;
    private boolean hasOnions = false;

    private int itemsCount;
    private double price;
    private String name;

    public BasicBurger(String bread, String meat, double price) {
        this.bread = bread;
        this.meat = meat;
        this.price = (price > .50  && price < 100)? price: 5.99;
        this.name = "Basic Burger";
    }
    public void addToTotal(double price, String item){
        itemsCount++;
        this.price+=price;
        System.out.println(item +" has been added " + price + "$ +");
    }

    public void addLettuce(){
        if(!hasLettuce){
            hasLettuce = true;
            addToTotal(.50 , "lettuce");
            System.out.println("Lettuce added");
        }else{
            System.out.println("Lettuce is already added");
        }
    }
    public void addTomato(){
        if(!hasTomato){
            hasTomato = true;
            addToTotal(.70, "tomato");
            System.out.println("Tomato added");
        }else{
            System.out.println("Tomato is already added");
        }
    }
    public void addPickles(){
        if(!hasPickles){
            hasPickles = true;
            addToTotal( .55, "pickles");
            System.out.println("Pickles added");

        }else{
            System.out.println("Tomato is already added");
        }
    }
    public void addOnions(){
        if(!hasOnions){
            hasOnions = true;
            addToTotal(.35, "onions");
            System.out.println("Onions added");
        }else{
            System.out.println("Onions is already added");

        }
    }

    public String getBread() {
        return bread;
    }

    public String getMeat() {
        return meat;
    }

    public boolean isHasLettuce() {
        return hasLettuce;
    }

    public boolean isHasTomato() {
        return hasTomato;
    }

    public boolean isHasPickles() {
        return hasPickles;
    }

    public boolean isHasOnions() {
        return hasOnions;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
