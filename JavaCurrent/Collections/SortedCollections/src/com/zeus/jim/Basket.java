package com.zeus.jim;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity){
        if((item != null) && (quantity > 0)){
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity){
        if((item != null) && (quantity > 0)){
            int inBasket = list.getOrDefault(item, 0);
            if(inBasket == quantity){
                System.out.println("Removing " + item.getName());
                list.remove(item);
            }else if(inBasket > quantity){
                System.out.println("Adjusting " + " -" + quantity + " " + item.getName() );
                list.put(item, inBasket - quantity);
            }else{
                return 0;
            }
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> getList(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nBasket List" + this.name + " contains: " + this.list.size() + ((this.list.size() > 1)? " items" : " item") +" \n" ;
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : this.list.entrySet()){
            s = s + item.getKey() + ", " + item.getValue() + " reserved \n";
            totalCost += item.getKey().getPrice() * item.getValue() ;
        }
        return s + " Total cost " + totalCost;
    }
}

