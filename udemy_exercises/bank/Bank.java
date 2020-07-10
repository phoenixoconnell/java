package udemy_exercises.bank;

import java.util.ArrayList;

public class Bank {
    
    public static void main(String[] args) {
        ArrayList<Branch> branches = new ArrayList<>();
        Branch branch = new Branch("Main Branch");
        branch.newAccount("Jayne Storm", 1000);
        branch.deposit("Jayne Storm", 500);
        branches.add(branch);
        branches.get(0).deposit("Jayne Storm", 250);
        branches.get(0).listCustomers();
        branches.get(0).listTransactions();
        branches.get(0).listTransactions("Jayne Storm");
    }
}
/*
**Banking w/ Java Classes**
   - **bank.Bank class**
      - List of Branches
      - Add a new branch
      - Add a customer to that branch with initial transaction
      - Add a transaction for an existing customer for that branch
      - Show a list of customers for a particular branch and optionally a list of their transactions
   - Demonstration autoboxing and unboxing in your code
   - Think about where you are adding the code to perform certain actions
   - **Branch class**
     - List of Customers
     - List of Transactions
   - **Customer Class**:
     - Customer Name
   - **Branch Class**:
     - addCustomer and initial transaction amount.
     - Also needs to add additional transactions for that customer/branch
   - **bank.Bank:**
*/