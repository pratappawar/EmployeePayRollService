package com.employeepayroll;

import org.junit.jupiter.api.Test;

public class EmployeePayRollServiceTest {

    static EmployeePayrollService employeePayrollService = new EmployeePayrollService();
    
    /**
     * Test case for printing welcome message
     */
    @Test
    public void printWelcomeMessage() {
        employeePayrollService.printWelcomeMessage();
    }
}
