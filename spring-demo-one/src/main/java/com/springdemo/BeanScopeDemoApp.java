package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        // if they are the same beans
        boolean result = (theCoach == alphaCoach);

        System.out.println("\nPointing to the sane object: "+result);
        System.out.println("\nMemory location for theCoach: "+ theCoach);
        System.out.println("\nMemory location for alphaCoach: "+ alphaCoach);
    }
}
