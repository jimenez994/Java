package zeus.jim;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BankAccount account = new BankAccount("12345",32.34,"Zeus", "j.zeus@hot.com","703599108 ");
        account.depositFunds(45);
        account.withdrawFunds(77.54);

        BankAccount account1 = new BankAccount();
        account.info();
        account1.info();

        VIPCustomer jj = new VIPCustomer("Jon", 5000, "j@j.com");
        System.out.println(jj.getCreditLimit() +" " + jj.getName());
    }
}
