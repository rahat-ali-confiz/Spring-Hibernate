package com.spring.aopdemo;

import com.spring.aopdemo.config.DemoConfig;
import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;
import com.spring.aopdemo.dto.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO membershipDAO =
                context.getBean("membershipDAO",MembershipDAO.class);


        // call the business container
        Account myAccount = new Account();
        accountDAO.addAccount(myAccount,true);
        accountDAO.doWork();

        // call the membership business method
        membershipDAO.addSillyAccount();
        membershipDAO.gpToSleep();

        // close the context
        context.close();

    }
}
