package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Printer printer = new Printer(40,true);
        printer.printPage(4);
        System.out.println(printer.getTonerLevel());
        printer.fillToner(40);
        System.out.println(printer.getTonerLevel());
        System.out.println(printer.getNumberOfPagesPrinted());

    }
}
