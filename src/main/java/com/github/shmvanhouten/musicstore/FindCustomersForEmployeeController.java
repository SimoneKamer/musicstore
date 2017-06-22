package com.github.shmvanhouten.musicstore;

import java.util.List;

public class FindCustomersForEmployeeController {

    private final CustomerService customerService;
    private final EmployeeService employeeService;

    public FindCustomersForEmployeeController(CustomerService customerService, EmployeeService employeeService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
    }

    public List<Customer> getCustomersForEmployee (String employeeName){
        Employee employee = employeeService.getEmployeeByName(employeeName);
        return customerService.getAllCustomersFromEmployee (employee);
    }
}
