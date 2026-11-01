class Employee_
{
    private String Empno;
    private String name;
    private String department;
    private double basic_pay;

    double DA;
    double HRA;
    double gross;
    static String CName = "Nothing";

    Employee_(String Empno, String name, String department, double basic_pay)
    {
        this.Empno = Empno;
        this.name = name;
        this.department = department;
        this.basic_pay = basic_pay;
        calc(); 
    }

    double calc()
    {
        DA = 0.1 * basic_pay;
        HRA = 0.2 * basic_pay;
        return gross = basic_pay + DA + HRA;
    }

    void display()
    {
        System.out.println("Company Name: " + CName);
        System.out.println("Employee No: " + Empno);
        System.out.println("Employee Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Basic_pay: Rs. " + basic_pay);
        System.out.println("Gross salary: Rs. " + gross);
    }

    public static void main(String[] args)
    {
        
        Employee_[] employees = {
            new Employee_("A21", "Rahul", "Finance", 45000),
            new Employee_("A22", "Priya", "HR", 40000),
            new Employee_("A23", "Amit", "Finance", 50000),
            new Employee_("A24", "Sneha", "Marketing", 42000),
            new Employee_("A25", "Rohan", "Sales", 38000)
        };

       
        Employee_ highestGrossEmp = employees[0];

        for (int i = 1; i < employees.length; i++) {
            if (employees[i].gross > highestGrossEmp.gross) {
                highestGrossEmp = employees[i];
            }
        }

        System.out.println("=== Employee with Highest Gross Salary ===");
        highestGrossEmp.display();
    }
}
