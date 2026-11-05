import java.util.ArrayList;
import java.util.Scanner;

// 1. Department Interface
interface Department {
    void printDepartmentDetails();
}

// 2. Hostel Class
class Hostel {
    protected String hostelName;
    protected String hostelLocation;
    protected int numberOfRooms;

    public void getHostelData(Scanner sc) {
        System.out.print("Enter Hostel Name: ");
        this.hostelName = sc.nextLine();
        System.out.print("Enter Hostel Location: ");
        this.hostelLocation = sc.nextLine();
        System.out.print("Enter Number of Rooms: ");
        this.numberOfRooms = Integer.parseInt(sc.nextLine());
    }

    public void printHostelData() {
        System.out.println("Hostel Name     : " + hostelName);
        System.out.println("Hostel Location : " + hostelLocation);
        System.out.println("Number of Rooms : " + numberOfRooms);
    }
}

// 3. Student Class extending Hostel and implementing Department
class Student extends Hostel implements Department {
    private String studentName;
    private String regdNo;
    private String electiveSubject;
    private double avgMarks;
    
    private String deptName;
    private String deptHead;

    public void getData(Scanner sc) {
        System.out.print("Enter Student Name: ");
        this.studentName = sc.nextLine();
        System.out.print("Enter Registration Number: ");
        this.regdNo = sc.nextLine();
        System.out.print("Enter Elective Subject: ");
        this.electiveSubject = sc.nextLine();
        System.out.print("Enter Average Marks: ");
        this.avgMarks = Double.parseDouble(sc.nextLine());

        System.out.print("Enter Department Name: ");
        this.deptName = sc.nextLine();
        System.out.print("Enter Department Head: ");
        this.deptHead = sc.nextLine();

        // Get hostel details
        super.getHostelData(sc);
    }

    public void printData() {
        System.out.println("\n----------------------------------");
        System.out.println("          STUDENT DETAILS         ");
        System.out.println("----------------------------------");
        System.out.println("Student Name    : " + studentName);
        System.out.println("Registration No : " + regdNo);
        System.out.println("Elective Subject: " + electiveSubject);
        System.out.println("Average Marks   : " + avgMarks);
        printDepartmentDetails();
        printHostelData();
        System.out.println("----------------------------------");
    }

    @Override
    public void printDepartmentDetails() {
        System.out.println("Department Name : " + deptName);
        System.out.println("Department Head : " + deptHead);
    }

    public String getRegdNo() {
        return regdNo;
    }

    public void migrateStudent(Scanner sc) {
        System.out.println("\n--- Migration Menu ---");
        System.out.println("1. Change Hostel");
        System.out.println("2. Change Department");
        System.out.print("Choose migration type: ");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {
            System.out.print("Enter New Hostel Name: ");
            this.hostelName = sc.nextLine();
            System.out.print("Enter New Hostel Location: ");
            this.hostelLocation = sc.nextLine();
            System.out.println("Hostel migrated successfully!");
        } else if (choice == 2) {
            System.out.print("Enter New Department Name: ");
            this.deptName = sc.nextLine();
            System.out.print("Enter New Department Head: ");
            this.deptHead = sc.nextLine();
            System.out.println("Department migrated successfully!");
        } else {
            System.out.println("Invalid choice!");
        }
    }
}

// 4. Driver Class (Main)
public class UniversityManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n=== University Management Menu ===");
            System.out.println("i) Admit new student");
            System.out.println("ii) Migrate a student");
            System.out.println("iii) Display details");
            System.out.println("iv) Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Student newStudent = new Student();
                    System.out.println("\nEnter Details for New Student:");
                    newStudent.getData(sc);
                    students.add(newStudent);
                    System.out.println("Student admitted successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students registered yet.");
                        break;
                    }
                    System.out.print("\nEnter Registration Number to migrate: ");
                    String searchRegd = sc.nextLine();
                    boolean found = false;

                    for (Student s : students) {
                        if (s.getRegdNo().equalsIgnoreCase(searchRegd)) {
                            s.migrateStudent(sc);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with Registration Number " + searchRegd + " not found.");
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No student records available.");
                    } else {
                        System.out.println("\n--- Displaying All Student Records ---");
                        for (Student s : students) {
                            s.printData();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting program. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}