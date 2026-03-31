package streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


import java.io.Serializable;

class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + " | " + name + " | " + department + " | " + salary;
    }
}


public class EmployeeSerializationApp {

    static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Kapil", "IT", 55000));
        employees.add(new Employee(102, "Amit", "HR", 42000));
        employees.add(new Employee(103, "Neha", "Finance", 48000));

        saveEmployees(employees);
        loadEmployees();
    }

    static void saveEmployees(List<Employee> employees) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(employees);
            System.out.println("Employees saved successfully.");

        } catch (IOException e) {
            System.out.println("Error while saving employees.");
        }
    }

    static void loadEmployees() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            List<Employee> employees = (List<Employee>) ois.readObject();

            System.out.println("\nEmployee List:");
            for (Employee e : employees) {
                System.out.println(e);
            }

        } catch (IOException e) {
            System.out.println("Error while reading file.");
        } catch (ClassNotFoundException e) {
            System.out.println("Employee class not found.");
        }
    }
}
