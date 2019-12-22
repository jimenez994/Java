package zeus.jim;

import java.util.ArrayList;

public class Branch {
    private ArrayList<Costumer> costumers = new ArrayList<Costumer>();
    private String name;

    public Branch(String name) {
        this.name = name;
    }

    public void showCostumers(){
        for (Costumer costumer: costumers) {
            System.out.println("--------------");
            System.out.println("Name: "+costumer.getName());
            System.out.println("Transactions: "+costumer.getTransactions().size());
            System.out.println("--------------");
        }
    }

    public void addCostumer(Costumer costumer){
        if(!costumer.getName().isEmpty()){
            costumers.add(costumer);
            System.out.println(costumer.getName() + "'s account has been created");
        }else{
            System.out.println("Costumer needs a name");
        }
    }
    public ArrayList<Costumer> getCostumers() {
        return costumers;
    }

    public String getName() {
        return name;
    }

}
