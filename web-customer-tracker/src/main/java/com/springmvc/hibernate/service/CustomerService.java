package com.springmvc.hibernate.service;

import com.springmvc.hibernate.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);
}
