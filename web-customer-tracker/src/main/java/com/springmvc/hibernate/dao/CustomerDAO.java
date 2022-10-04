package com.springmvc.hibernate.dao;

import com.springmvc.hibernate.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomers(int theId);
}
