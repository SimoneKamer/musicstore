package com.github.shmvanhouten.musicstore;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerRepository {
    public List<Customer> getAllCustomersFromEmployee (Employee employee){
        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer("Simone","Kamer");
        customers.add(customer1);
        Customer customer2 = new Customer("Sjoerd","van Houten");
        customers.add(customer2);

        return customers;
    }

}
