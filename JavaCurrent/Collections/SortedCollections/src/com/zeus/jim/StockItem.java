package com.zeus.jim;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityInStock;
    private int reserved;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;
        this.reserved = 0;
    }

    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0.0){
            this.price = price;
            System.out.println("Price set to " + price);
        }
    }

    public int quantityReserved() {
        return reserved;
    }

    public int availableQuantity() {
        return quantityInStock - reserved;
    }

    public void adjustReservedItems(int quantity){
        if(quantity > 0 && (quantity + reserved) <= this.quantityInStock){
            this.reserved += quantity;
            System.out.println(quantity + "  " + this.name + " added" );
        }
    }

    public void adjustUnReservedItems(int quantity){
        if(quantity > 0 && this.reserved >= quantity){
            this.reserved -= quantity;
            System.out.println(quantity + "  " + this.name + " remove" );
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityInStock + quantity;
        if (newQuantity >= 0) {
            this.quantityInStock = newQuantity;
        }
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 46;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(obj == null || (obj.getClass() != this.getClass())){
            return false;
        }
        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int compareTo(StockItem o) {
//        System.out.println("Calling compare method");
        if(o == this){
            return 0;
        }
        if(o != null){
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return "StockItem -> " + "name: " + name + ", price: " + price + ", quantity: " + quantityInStock;
    }
}
