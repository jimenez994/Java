package zeus.jim;

public class VIPCustomer {
    private String name;
    private int creditLimit;
    private String email;

    public VIPCustomer(){
        this.name = "no name";
        this.creditLimit = 0;
        this.email = "no email";
    }

    public VIPCustomer(String name, int creditLimit) {
        this.name = name;
        this.creditLimit = creditLimit;
    }

    public VIPCustomer(String name, int creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
