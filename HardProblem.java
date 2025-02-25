import java.io.*;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private String designation;
    private double salary;

    public Employee(String name, int id, String designation, double salary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Designation: " + designation + ", Salary: " + salary;
    }

    public String getDetails() {
        return name + "," + id + "," + designation + "," + salary;
    }
}

public class EmployeeApp {

    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                // Option 1: Add Employee
                System.out.print("Enter Employee Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Employee ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                System.out.print("Enter Designation: ");
                String designation = scanner.nextLine();
                System.out.print("Enter Salary: ");
                double salary = scanner.nextDouble();
                Employee employee = new Employee(name, id, designation, salary);

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                    writer.write(employee.getDetails());
                    writer.newLine();
                    System.out.println("Employee added successfully!");
                } catch (IOException e) {
                    System.out.println("Error saving employee details.");
                }

            } else if (choice == 2) {
                // Option 2: Display All Employees
                try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] details = line.split(",");
                        System.out.println("ID: " + details[1] + ", Name: " + details[0] + ", Designation: " + details[2] + ", Salary: " + details[3]);
                    }
                } catch (IOException e) {
                    System.out.println("Error reading employee details.");
                }

            } else if (choice == 3) {
                // Option 3: Exit
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid option! Try again.");
            }
        }

        scanner.close();
    }
}
