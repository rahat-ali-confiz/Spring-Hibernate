package com.spring.aopdemo;

import com.spring.aopdemo.config.DemoConfig;
import com.spring.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);

        // call the business container
        accountDAO.addAccount();

        // do it again!
        System.out.println("\n let's call it again!\n");

        // call the business method again
        accountDAO.addAccount();

        // close the context
        context.close();

    }
}
