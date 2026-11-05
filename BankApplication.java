// Abstract class Accounts
abstract class Accounts {
    // Data Members
    protected double balance;
    protected String accountNumber;
    protected String accountHoldersName;
    protected String address;

    // Constructor to initialize account details
    public Accounts(double balance, String accountNumber, String accountHoldersName, String address) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountHoldersName = accountHoldersName;
        this.address = address;
    }

    // Abstract methods
    public abstract void withdrawal(double amount);
    public abstract void deposit(double amount);

    // Concrete method to display the balance and account number details
    public void display() {
        System.out.println("--- Account Details ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHoldersName);
        System.out.println("Address        : " + address);
        System.out.println("Current Balance: $" + balance);
    }
}

// Subclass SavingsAccount
class SavingsAccount extends Accounts {
    // Additional Data Member
    private double rateOfInterest;

    // Constructor
    public SavingsAccount(double balance, String accountNumber, String accountHoldersName, String address, double rateOfInterest) {
        super(balance, accountNumber, accountHoldersName, address);
        this.rateOfInterest = rateOfInterest;
    }

    // Implementing abstract withdrawal method
    @Override
    public void withdrawal(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else {
            System.out.println("Withdrawal failed: Invalid amount or insufficient balance.");
        }
    }

    // Implementing abstract deposit method
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Deposit failed: Please enter a valid positive amount.");
        }
    }

    // Method to calculate total amount based on rate of interest over a given period (in years)
    public void calculateAmount(int years) {
        double interest = (balance * rateOfInterest * years) / 100;
        double totalAmount = balance + interest;
        System.out.println("--- Interest Calculation (" + years + " years) ---");
        System.out.println("Interest Rate   : " + rateOfInterest + "%");
        System.out.println("Calculated Interest: $" + interest);
        System.out.println("Total Amount    : $" + totalAmount);
    }
}

// Main class to test the implementation
public class BankApplication {
    public static void main(String[] args) {
        // Creating an object of SavingsAccount
        SavingsAccount myAccount = new SavingsAccount(5000.0, "SA-98765", "Alice Smith", "42 Wallaby Way", 4.5);

        // Display initial account status
        myAccount.display();
        System.out.println();

        // Deposit money
        myAccount.deposit(1500.0);
        System.out.println();

        // Withdraw money
        myAccount.withdrawal(2000.0);
        System.out.println();

        // Display updated balance via display() method
        myAccount.display();
        System.out.println();

        // Calculate amount with interest for 3 years
        myAccount.calculateAmount(3);
    }
}