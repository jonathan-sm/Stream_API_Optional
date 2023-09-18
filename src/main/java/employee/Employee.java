package employee;

import java.util.Objects;
import java.util.Random;

public class Employee {

    private final String name;
    private final  String surname;


    private final  int department;
    private final int salary;

    public Employee(String name, String surname) {
        Random random = new Random();
        this.name = name;
        this.surname = surname;
        this.department= random.nextInt(2)+1;
        this.salary= random.nextInt(10000)*1000;

    }

    public Employee(String firstName, String lastName, int department) {
       Random random = new Random();
        this.name = firstName;
        this.surname = lastName;
        this.department = random.nextInt(2)+1;
        this.salary = random.nextInt(10000)*1000;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name=" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }


}

