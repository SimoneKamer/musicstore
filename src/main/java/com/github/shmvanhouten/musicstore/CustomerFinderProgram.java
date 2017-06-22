package com.github.shmvanhouten.musicstore;

import java.util.List;

public class CustomerFinderProgram {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        CustomerService customerService = new CustomerService(customerRepository);
        EmployeeService employeeService = new EmployeeService();
        FindCustomersForEmployeeController controller = new FindCustomersForEmployeeController(customerService, employeeService);


        List<Customer> customersForEmployee = controller.getCustomersForEmployee("Marco Beelen");

        for (Customer customer: customersForEmployee) {
            System.out.println(customer.getFirstName() + " " + customer.getLastName());

        }

    }
}
