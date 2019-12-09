package zeus.jim;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String costumerName;
    private String email;
    private String phone;

    public BankAccount(){
        this("123",1.00,"No name","No email", "No number");
    }

    public BankAccount(String accountNumber, double balance, String costumerName, String email, String phone) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.costumerName = costumerName;
        this.email = email;
        this.phone = phone;
    }

    public void info(){
        System.out.println("___________________________________");
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Name: " + this.costumerName);
        System.out.println("Email: " +this.email);
        System.out.println("Phone: " + this.phone);
        System.out.println("Account Balance: " + balance );
        System.out.println("-----------------------------------");
    }

    public void depositFunds(double amount){
        this.balance += amount;
        System.out.println("You have deposit "+ amount +" your current valance is now " + this.balance);
    }

    public void withdrawFunds(double amount){
        if(this.balance - amount < 0 ){
            System.out.println("Insufficient funds");
        }else{
            System.out.println("You have successfully withdrawn " + amount + " current balance is now " + this.balance);
            this.balance -= amount;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
