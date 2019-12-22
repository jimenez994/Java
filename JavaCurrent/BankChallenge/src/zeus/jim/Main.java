package zeus.jim;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bank wells = new Bank("Wells Fargo");
        bankDetails(wells);
        Branch annBranch = new Branch("Annandale Branch");
        Branch falls = new Branch("Falls Church Branch");
        Costumer cos1 = new Costumer("John");
        wells.addBranch(annBranch);
        wells.addBranch(falls);
        falls.addCostumer(cos1);
        falls.showCostumers();

        cos1.addTransaction(23.25);
        cos1.addTransaction(99.23);
        falls.showCostumers();
        cos1.showTransactions();


    }

    public static void bankDetails(Bank bank){
        System.out.println("====== "+ bank.getName()+" ======");
        System.out.println(bank.getBranches().size() +" Branches");
            for (Branch branch: bank.getBranches()) {
                System.out.println("-----------------------");
                System.out.println(branch.getName());
                System.out.println(branch.getCostumers().size()+ " Costumers");
                System.out.println("-----------------------");
            }
        System.out.println("====================");
    }

    public static void menu(){
        System.out.println("------------------");
        System.out.println("0 - Show menu");
        System.out.println("1 - Create new branch");
        System.out.println("2 - New costumer");
        System.out.println("3 - Add new transaction");
        System.out.println("4 - Show customer transactions");
        System.out.println("5 - Remove customer");
        System.out.println("9 - Quit");
        System.out.println("-------------------");
    }
}
