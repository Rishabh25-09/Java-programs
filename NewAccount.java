import java.util.*;
interface bank 
{
    void bankdetails();
}
class Customer
{
    String name;
    int customerID;

    Customer(String name, int customerID)
    {
        this.name=name;
        this.customerID=customerID;
    }

    void display()
    {
        System.out.println("Name: "+name);
        System.out.println("Customer ID: "+customerID);
    }

}

class Account extends Customer implements bank 
{
    int Accountno;
    double balance;

    Account(String name, int customerID, int Accountno, double balance)
    {
        super(name, customerID);
        this.Accountno=Accountno;
        this.balance=balance;
    }

    public void bankdetails()
    {
    System.out.println("Bank Name: SBI");
    }

    void displayAccount()
    {
        System.out.println("Account number: "+Accountno);
        System.out.println("Balance: "+balance);
    }
} 

public class NewAccount
{
    public static void main(String[] args) 
        {
            Account a=new Account("Rishabh", 2387689, 459384, 45000.0);
            a.display();
            a.displayAccount();
        }
}