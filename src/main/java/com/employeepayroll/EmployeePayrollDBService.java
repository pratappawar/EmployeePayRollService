package com.employeepayroll;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {

    /**
     * Establish the database connection
     * create statement
     * execute the query
     * @return
     * @throws SQLException
     */
    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String password = "Bibhishan@123";
        Connection connection;
        System.out.println("Connecting to database:" + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!!!" + connection);
        return connection;
    }

    /**
     * this method will retrieve the data.
     * @return employeePayrollList
     */
    public List<EmployeePayrollData> readData() {
        String sql = "select * from employee_payroll";
        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        try {
            Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                double salary = result.getDouble("salary");
                LocalDate startDate = result.getDate("startDate").toLocalDate();
                employeePayrollList.add(new EmployeePayrollData(id,name,salary,startDate));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollList;
    }
}