package com.employeepayroll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static com.employeepayroll.EmployeePayrollService.IOService.FILE_IO;

public class EmployeePayRollServiceTest {

    static EmployeePayrollService employeePayrollService = new EmployeePayrollService();

    /**
     * Test case for printing welcome message
     */
    @Test
    public void printWelcomeMessage() {
        employeePayrollService.printWelcomeMessage();
    }

    /**
     * test case to write data to the file
     */
    @Test
    public void given3Employees_WhenWrittenTo_FileShouldMatch_EmployeeEntries() {
        EmployeePayrollData[] arrayOfEmps = {
                new EmployeePayrollData(1, "Jeff Bezos", 100000.0),
                new EmployeePayrollData(2, "Bill Gates", 500000.0),
                new EmployeePayrollData(3, "Elon Musk", 4000000.0)};

        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        employeePayrollService.writeEmployeePayrollData(FILE_IO);
        employeePayrollService.printData(FILE_IO);
        long entries = employeePayrollService.countEntries(FILE_IO);
        Assertions.assertEquals(3, entries);
    }

    @Test
    public void givenFileOn_ReadingFrom_File_ShouldMatch_EmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> entries = employeePayrollService.readPayrollData(FILE_IO);
        Assertions.assertEquals(3, entries);
    }

    /**
     * test case to fetch records from database table employee_payroll
     */
    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount(){
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> databaseEmployeePayrolls = employeePayrollService.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
        System.out.println("records"+databaseEmployeePayrolls);
        Assertions.assertEquals(3,databaseEmployeePayrolls.size());
    }
}
