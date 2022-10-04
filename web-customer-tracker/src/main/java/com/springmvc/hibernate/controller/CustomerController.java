package com.springmvc.hibernate.controller;

import com.springmvc.hibernate.dao.CustomerDAO;
import com.springmvc.hibernate.entity.Customer;
import com.springmvc.hibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        // create model attribute to bind form data

        Customer theCustomer = new Customer();
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        // save the customer using our service
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel){

        // get the customer from the service
        Customer theCustomer = customerService.getCustomers(theId);

        // set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer",theCustomer);

        // send over to our form
        return "customer-form";

    }


}
