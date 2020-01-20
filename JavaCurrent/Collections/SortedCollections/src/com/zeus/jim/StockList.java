package com.zeus.jim;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
//        LinkedHashMap will keep the item in the order add it
        this.list = new LinkedHashMap<>();
    }

    public int addStockItem(StockItem item){
        if (item != null){
//            getting the item if already in the list
//            check if already have quantities is this item
            StockItem inStock = list.getOrDefault(item.getName(), item);
//            if there already stocks on this item, adjust the quantity
            if (inStock != item){
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity){
        StockItem inStockItem = list.getOrDefault(item, null);
        if((inStockItem != null) && (inStockItem.quantityInStock() > quantity) && (quantity > 0)){
            inStockItem.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public int reserveStock(String item, int quantity){
        StockItem inStockItem = list.getOrDefault(item, null);
        if((inStockItem != null) && (inStockItem.quantityInStock() >= (quantity + inStockItem.quantityReserved()) && (quantity > 0))){
            inStockItem.adjustReservedItems(quantity);
            return quantity;
        }else{
            System.out.println("Could not add " + quantity + " " + item);
            return 0;
        }
    }

    public int unReserveStock(String item, int quantity){
        StockItem inStockItem = list.getOrDefault(item, null);
        if((inStockItem != null) && (inStockItem.quantityReserved() >= quantity  && (quantity > 0))){
            inStockItem.adjustUnReservedItems(quantity);
            return quantity;
        }else{
            System.out.println("Could not remove " + quantity + " " + item);
            return 0;
        }
    }

    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String, Double> PriceList(){
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String,StockItem> item:this.list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items(){
        return Collections.unmodifiableMap(this.list);
    }

    @Override
    public String toString() {
        String s = "\nStock List \n" ;
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : this.list.entrySet()){
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s = s + stockItem + ", There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
//            %.2f makes the decimal number to two decimal place
            s = s + String.format("%.2f", itemValue)  + "\n";
            totalCost += itemValue;
        }
        return s + " Total stock value " + totalCost;
    }
}
