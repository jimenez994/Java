package zeus.jim;

public class Printer {
    private double tonerLevel;
    private int numberOfPagesPrinted = 0;
    private boolean isADuplex;

    public Printer(double tonerLevel, boolean isADuplex) {
        this.tonerLevel = (tonerLevel > 0 && tonerLevel <= 100)?tonerLevel:0;
        this.isADuplex = isADuplex;
    }

    public void fillToner(double amount){
        if(amount > 0 && amount+this.tonerLevel <= 100){
            tonerLevel+=amount;
            System.out.println("printer now has " + tonerLevel + "% level");
        }else if(amount+this.tonerLevel > 100){
            System.out.println("Sorry can't hold that much ink");
        }else{
            System.out.println("Invalid amount");
        }
    }

    public void printPage(int pages){
        if(tonerLevel > 2 && isADuplex){
            int pagesInDuplexMode = pages%2 + pages/2;
            this.numberOfPagesPrinted+= pagesInDuplexMode;
            tonerLevel-=2;
            System.out.println(pagesInDuplexMode + " pages printed in duplex success ");

        }else if(tonerLevel > 1 && !isADuplex){
            this.numberOfPagesPrinted += pages;
            System.out.println(pages + " pages printed");
        }else{
            System.out.println("Sorry printer needs ink");
        }
    }

    public double getTonerLevel() {
        return tonerLevel;
    }

    public int getNumberOfPagesPrinted() {
        return numberOfPagesPrinted;
    }

    public boolean isADuplex() {
        return isADuplex;
    }
}
