package cf.eima.app;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Sprint {

    public static void main(String[] args) {
        String file = "./data/employees.csv";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file), true));

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter employee data!" + "\n" + "Example: Name, Surname, BadgeID, Salary");

            String employee = sc.nextLine();
            String fileLine = employee + "\n";
            bw.write(fileLine);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line = "";
        String split = ", ";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] employees = line.split(split);
                Employee emp1 = new Employee(employees[0], employees[1], Integer.parseInt(employees[2]), Double.parseDouble(employees[3]));
                System.out.println(emp1.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Employee {
    private String name;
    private String surname;
    private int badgeId;
    private double salary;

    Employee() {
    }

    Employee(String firstName, String lastName, int badge, double monthlySalary) {
        this.name = firstName;
        this.surname = lastName;
        this.badgeId = badge;
        this.salary = monthlySalary;

    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getTabNumber() {
        return this.badgeId;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBadgeId(int badgeId) {
        this.badgeId = badgeId;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "{ Name: " + name + ", surname: " + surname
                + ", badge id: " + badgeId + ", salary: " + salary + '}';
    }
}
