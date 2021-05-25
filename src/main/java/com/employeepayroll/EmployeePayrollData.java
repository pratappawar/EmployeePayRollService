package com.employeepayroll;

public class EmployeePayrollData {

    private int id;
    private String name;
    private double salary;

    /**
     * parameterized constructor
     * @param id
     * @param name
     * @param salary
     */
    public EmployeePayrollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /**
     * Overridden method to print the details
     * @return
     */
    @Override
    public String toString() {
        return "EmployeePayrollData [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}