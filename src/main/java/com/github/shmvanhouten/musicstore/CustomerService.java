package com.github.shmvanhouten.musicstore;

import java.util.List;

public class CustomerService {
        private final CustomerRepository customerRepository;

        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public List<Customer> getAllCustomersFromEmployee(Employee employee){
            return customerRepository.getAllCustomersFromEmployee(employee);
        }
    }

