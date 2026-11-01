import java.util.Scanner;

// 1. Gross Interface: Declares the contract for calculating gross salary
interface Gross {
    void gross_salary();
}

// 2. Employee Base Class: Stores fundamental employee information
class Employee {
    String name;
    double basicSalary;

    // Explicit default constructor
    public Employee() {
    }

    // Method to accept employee details from user
    public void acceptEmployeeDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Basic Salary: ");
        basicSalary = scanner.nextDouble();
        scanner.close(); // Closes the scanner to resolve the resource leak warning
    }
}

// 3. Salary Derived Class: Inherits Employee and implements Gross Interface
class Salary extends Employee implements Gross {
    double da, hra, totalGrossSalary;

    // Overriding the interface method to compute allowances and gross salary
    @Override
    public void gross_salary() {
        da = basicSalary * 0.50;
        hra = basicSalary * 0.20;
        totalGrossSalary = basicSalary + da + hra;
    }

    // Method to display complete salary details
    public void displaySalaryDetails() {
        System.out.println("\n==================================");
        System.out.println("      EMPLOYEE SALARY DETAILS     ");
        System.out.println("==================================");
        System.out.println("Employee Name : " + name);
        System.out.println("Basic Salary  : " + basicSalary);
        System.out.println("DA (50%)      : " + da);
        System.out.println("HRA (20%)     : " + hra);
        System.out.println("----------------------------------");
        System.out.println("Gross Salary  : " + totalGrossSalary);
        System.out.println("==================================");
    }
}

// Main Execution Class
public class MultipleInheritanceFramework {
    public static void main(String[] args) {
        // Instantiate the Salary class
        Salary employeeSalary = new Salary();

        // Input details, calculate gross, and display report
        employeeSalary.acceptEmployeeDetails();
        employeeSalary.gross_salary();
        employeeSalary.displaySalaryDetails();
    }
}