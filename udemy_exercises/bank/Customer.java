package udemy_exercises.bank;

public class Customer {
    private String name;
    private Double balance;
    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public void transaction(double amount) {
        this.balance += amount;
    }
}
/*
- **Customer Class**:
- Customer Name
*/

