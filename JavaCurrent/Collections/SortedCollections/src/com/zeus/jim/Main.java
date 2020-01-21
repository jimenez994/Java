package com.zeus.jim;

import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread",.89,100);
        stockList.addStockItem(temp);

        temp = new StockItem("cake",12.39,100);
        stockList.addStockItem(temp);
        temp = new StockItem("car",25000,10);
        stockList.addStockItem(temp);
        temp = new StockItem("yogurt",6.34,30);
        stockList.addStockItem(temp);
        temp = new StockItem("cheese",2.50,100);
        stockList.addStockItem(temp);
        temp = new StockItem("milk",3.98,100);
        stockList.addStockItem(temp);
        temp = new StockItem("cookies",2.89,5);
        stockList.addStockItem(temp);
        temp = new StockItem("oreo",3.23,100);
        stockList.addStockItem(temp);
        temp = new StockItem("serial",2.25,50);
        stockList.addStockItem(temp);
        temp = new StockItem("egg",1.89,1);
        stockList.addStockItem(temp);
        temp = new StockItem("egg",1.89,34);
        stockList.addStockItem(temp);temp = new StockItem("egg",1.89,10);
        stockList.addStockItem(temp);


        Basket jonsBasket = new Basket("Jon");
        reserveStock(jonsBasket, "cookies", 4);
//        System.out.println(jonsBasket);

        reserveStock(jonsBasket, "cookies", 6);
        reserveStock(jonsBasket, "oreo", 4);
        reserveStock(jonsBasket, "egg", 4);
        reserveStock(jonsBasket, "milk", 1);
        reserveStock(jonsBasket, "car", 1);
        reserveStock(jonsBasket, "plane", 4);
        reserveStock(jonsBasket, "bed", 4);
        System.out.println(jonsBasket);

        unReserveStock(jonsBasket, "car", 3);

        payBasket(jonsBasket);
        System.out.println(jonsBasket);


        System.out.println(stockList);


    }

    private static int reserveStock(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
        }
        if(stockList.reserveStock(item, quantity) != 0){
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }

    private static int unReserveStock(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
        }
        if(stockList.unReserveStock(item, quantity) != 0){
            basket.removeFromBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }

    private static void payBasket(Basket basket){
        if(basket.getList().isEmpty()){
            System.out.println("Sorry your basket is empty");
        }else{
            System.out.println("... Processing");
            for (Map.Entry<StockItem, Integer> item: basket.getList().entrySet()) {
                sellStock(basket, item.getKey().getName(), item.getValue());
            }
            basket.clear();
//            System.out.println("You paid " + basket.);
        }

    }
    
    private static int sellStock(Basket basket, String item, int quantity ){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.sellStock(item,quantity) != 0 ){
//            basket.addtoBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
