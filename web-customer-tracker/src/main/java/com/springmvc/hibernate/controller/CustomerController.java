package com.springmvc.hibernate.controller;

import com.springmvc.hibernate.dao.CustomerDAO;
import com.springmvc.hibernate.entity.Customer;
import com.springmvc.hibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

    // need to inject the customer service

    @Autowired
    private CustomerService customerService;

    @GetMapping( "/list")
    public String listCustomers(Model model){

        // get customers from the service
        List<Customer> theCustomers  = customerService.getCustomers();

        // add the customers to the model
        model.addAttribute("customers",theCustomers);


        return "list-customers";
    }

}
