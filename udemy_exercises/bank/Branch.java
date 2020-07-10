package udemy_exercises.bank;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;
    private ArrayList<Transaction> transactions;
    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>();
        transactions = new ArrayList<>();
    }
    
    public void newAccount(String name, double deposit) {
        Customer c = new Customer(name, deposit);
        customers.add(c);
        transactions.add(new Transaction(c, deposit));
    }
    
    public void deposit(String name, double deposit) {
        Customer c = findCustomer(name);
        if(c != null) {
            c.transaction(deposit);
            transactions.add(new Transaction(c, deposit));
        } else {
            System.out.println("Customer not found!");
        }
    }
    
    public void debit(String name, double amount) {
        Customer c = findCustomer(name);
        if(c != null) {
            c.transaction(-(amount));
            transactions.add(new Transaction(c, -(amount)));
        } else {
            System.out.println("Customer not found!");
        }
    }
    
    public void listCustomers() {
        System.out.print("Customers at " + this.name);
        this.customers.stream()
                .forEach(c -> {
                    System.out.println(c.getName() + ": " + c.getBalance());
                });
    }
    
    public void listTransactions() {
        System.out.println("All transactions at" + this.name);
        this.transactions.stream()
                .forEach(t -> {
                    System.out.println(t.customer.getName() + ": " + t.amount);
                });
    }
    
    public void listTransactions(String name) {
        System.out.println("Transactions for " + name + " at " + this.name);
        this.transactions.stream()
                .filter(t -> {
                    return t.customer.getName().equals(name);
                })
                .forEach(tf -> {
                    System.out.println(tf.customer.getName() + ": " + tf.amount);
                });
        System.out.println("Balance for " + name + ": " + findCustomer(name).getBalance());
    }
    
    private Customer findCustomer(String name) {
        Customer c = this.customers.stream()
                .filter(cust -> {
                    return cust.getName().equals(name);
                })
                .findAny()
                .orElse(null);
        return c;
    }
}

class Transaction {
    Customer customer;
    Double amount;
    Transaction(Customer customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }
}
/*
**Branch Class**:
     - addCustomer and initial transaction amount.
     - Also needs to add additional transactions for that customer/branch
*/
