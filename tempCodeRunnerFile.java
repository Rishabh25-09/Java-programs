class Employee {
    
    private String name;
    private String department;
    private double salary;

    
    static String CName = "Nothing";

    
    Employee(String name, String department, double salary) 
    {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    
    void display() 
    {
        System.out.println("Company Name: " + CName);
        System.out.println("Employee Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: Rs. " + salary);
        System.out.println("-BREAK-");
    }

    public static void main (String[]args)
    {
        Employee e1 = new Employee("Rahul", "IT", 45000);
        Employee e2 = new Employee("Priya", "HR", 40000);
        Employee e3 = new Employee("Amit", "Finance", 50000);
        Employee e4 = new Employee("Sneha", "Marketing", 42000);
        Employee e5 = new Employee("Rohan", "Sales", 38000);

        
        e1.display();
        e2.display();
        e3.display();
        e4.display();
        e5.display();
    }
}