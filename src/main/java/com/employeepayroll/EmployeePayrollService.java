package com.employeepayroll;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class EmployeePayrollService {

    //Actually tells me to where I can write date like i have declared enum
    public enum IOService{CONSOLE_IO,FILE_IO,DB_IO,REST_IO}
    public List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this();
        this.employeePayrollList = employeePayrollList;
    }

    /**
     *
     */
    public void printWelcomeMessage() {
        System.out.println("Welcome to the Employee PayRoll Service Program");
    }

    /**
     * Default constructor where i declare Arraylist
     */
    public EmployeePayrollService() {
        employeePayrollList = new ArrayList<>();
    }

    /**
     * Main method to take input from user
     * @param args
     */
    public static void main(String[] args) {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.printWelcomeMessage();
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);
    }

    /**
     *  Read Employee Payroll data from console
     * @param consoleInputReader
     */
    private void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter Employee ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee Name ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee Salary ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    /**
     * Write Employee Payroll data to console
     */
    void writeEmployeePayrollData(IOService ioService) {
        if (ioService.equals(ioService.CONSOLE_IO))
            System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
        else if (ioService.equals(ioService.FILE_IO))new EmployeePayrollFileIOService().writeData(employeePayrollList);
    }

    /**
     * Print the entries
     * @param ioService
     */
    public void printData(IOService ioService) {
        if (ioService.equals(ioService.FILE_IO))new EmployeePayrollFileIOService().printData();
    }

    /**
     * Count entries in the file
     * @param ioService
     * @return
     */
    public long countEntries(IOService ioService) {
        if (ioService.equals(ioService.FILE_IO))
            return new EmployeePayrollFileIOService().countEntries();
        return 0;
    }

    /**
     * read data from file
     * @param ioService
     * @return
     */
    public List<EmployeePayrollData> readPayrollData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            this.employeePayrollList = new EmployeePayrollFileIOService().readData();
        return employeePayrollList;
    }

    /**
     * read Employee payroll data from database
     * @param ioService
     * @return
     */
    public List<EmployeePayrollData> readEmployeePayrollData(IOService ioService)
    {
        if(ioService.equals(IOService.DB_IO))
            this.employeePayrollList = new EmployeePayrollDBService().readData();
        return this.employeePayrollList;
    }
}