package com.springdemo.annotations.PracticeActicity7;

import com.springdemo.annotations.Coach.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeActivityDemoApp {
    public static void main(String[] args) {

        // read spring config java file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigSport.class);

        // get the bean from spring container
        Coach theCoach = context.getBean("footballCoach", Coach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call a method on the bean
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
