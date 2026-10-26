class Employee_
{
    private String Empno;
    private String name;
    private String department;
    private double basic_pay;

    double DA;
    double HRA;
    double gross;
    static String CName= "Nothing";

    Employee_(String Empno, String name, String department, double basic_pay)
    {
        this.Empno=Empno;
        this.name=name;
        this.department=department;
        this.basic_pay=basic_pay;
    }

    double calc()
    {
        DA= 0.1*basic_pay;
        HRA= 0.2*basic_pay;
        return gross=basic_pay+DA+HRA;
    }

    void display()
    {
        System.out.println("Company Name: " + CName);
        System.out.println("Employee Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Basic_pay: Rs. " + basic_pay);
        
    }

    public static void main (String[]args)
    {
        Employee_ e1= new Employee_("A21", "Rahul", "Finance", 45000);
        Employee_ e2 = new Employee_("A22", "Priya", "HR", 40000);
        Employee_ e3 = new Employee_("A23" , "Amit", "Finance", 50000);
        Employee_ e4 = new Employee_("A24", "Sneha", "Marketing", 42000);
        Employee_ e5 = new Employee_("A25", "Rohan", "Sales", 38000);

        e1.display();
        double a=e1.calc();
        System.out.println("Gross salary:"+ a);
        System.out.println("-BREAK-");
         e2.display();
        double b=e2.calc();
        System.out.println("Gross salary:"+ b);
        System.out.println("-BREAK-");
         e3.display();
        double c=e3.calc();
        System.out.println("Gross salary:"+ c);
        System.out.println("-BREAK-");
         e4.display();
        double d=e4.calc();
        System.out.println("Gross salary:"+ d);
        System.out.println("-BREAK-");
         e5.display();
        double e=e5.calc();
        System.out.println("Gross salary:"+ e);
        System.out.println("-BREAK-");
    }
}