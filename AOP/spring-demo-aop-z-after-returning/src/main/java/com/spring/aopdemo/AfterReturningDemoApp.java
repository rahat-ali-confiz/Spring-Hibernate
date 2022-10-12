package com.spring.aopdemo;

import com.spring.aopdemo.config.DemoConfig;
import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;
import com.spring.aopdemo.dto.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);

        // call method to find the accounts
        List<Account> theAccounts = accountDAO.findAccounts();

        // display the accounts
        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("-----");

        System.out.println(theAccounts);

        System.out.println("\n");

        // close the context
        context.close();

    }
}
