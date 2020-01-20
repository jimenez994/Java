package com.zeus.jim;

import java.util.Map;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantity;
    private int reserved;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
        this.reserved = 0;
    }

    public StockItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

    public int quantityInStock() {
        return quantity;
    }

    public void adjustReservedItems(int quantity){
        if(quantity > 0 && (quantity + reserved) <= this.quantity){
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
        int newQuantity = this.quantity + quantity;
        if (newQuantity >= 0) {
            this.quantity = newQuantity;
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
        return "StockItem -> " + "name: " + name + ", price: " + price + ", quantity: " + quantity;
    }
}
