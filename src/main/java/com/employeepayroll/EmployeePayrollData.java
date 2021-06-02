package com.employeepayroll;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeePayrollData {

    public int id;
    public String name;
    public double salary;
    public LocalDate startDate;

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
     * parameterized constructor
     * @param id
     * @param name
     * @param salary
     * @param startDate
     */
    public EmployeePayrollData(int id, String name, double salary, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.startDate=startDate;
    }

    /**
     * Overridden method to print the details
     * @return
     */
    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", startDate=" + startDate +
                '}'+"\n";
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePayrollData that = (EmployeePayrollData) o;
        return id == that.id && Double.compare(that.salary, salary) == 0 && Objects.equals(name, that.name);
    }
}