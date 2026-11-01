import java.util.Scanner;

interface Gross {
    void gross_salary();
}


class Employee {
    String name;
    double basicSalary;


    public Employee() {
    }


    public void acceptEmployeeDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Basic Salary: ");
        basicSalary = scanner.nextDouble();
        scanner.close(); 
    }
}


class Salary extends Employee implements Gross {
    double da, hra, totalGrossSalary;


    @Override
    public void gross_salary() {
        da = basicSalary * 0.50;
        hra = basicSalary * 0.20;
        totalGrossSalary = basicSalary + da + hra;
    }


    public void displaySalaryDetails() {
       
        System.out.println("Employee Name : " + name);
        System.out.println("Basic Salary  : " + basicSalary);
        System.out.println("DA (50%)      : " + da);
        System.out.println("HRA (20%)     : " + hra);
        System.out.println("Gross Salary  : " + totalGrossSalary);
        System.out.println("==BREAK==");
    }
}


public class MultipleInheritanceFramework {
    public static void main(String[] args) {
        
        Salary employeeSalary = new Salary();

        
        employeeSalary.acceptEmployeeDetails();
        employeeSalary.gross_salary();
        employeeSalary.displaySalaryDetails();
    }
}
