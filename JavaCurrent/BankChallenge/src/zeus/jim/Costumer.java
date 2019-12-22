package zeus.jim;

import java.util.ArrayList;

public class Costumer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<Double>();

    public Costumer(String name) {
        this.name = name;
    }

    public void addTransaction(double amount){
        if(amount > 0){
            transactions.add(amount);
        }else{
            System.out.println("Invalid amount");
        }
    }

    public void showTransactions(){
        for (double amount: transactions) {
            System.out.println("T:  $" + amount);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
