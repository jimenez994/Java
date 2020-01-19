package com.zeus.jim;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new HashMap<>();
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

    public StockItem get(String key){
        return list.get(key);
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

            double itemValue = stockItem.getPrice() + stockItem.quantityInStock();

            s = s + stockItem + ", There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
            s = s + itemValue + "\n";
            totalCost += itemValue;
        }
        return s + " Total stock value " + totalCost;
    }
}
