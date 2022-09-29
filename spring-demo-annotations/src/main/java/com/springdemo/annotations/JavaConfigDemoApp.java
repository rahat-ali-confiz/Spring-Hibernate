package com.springdemo.annotations;

import com.springdemo.annotations.Coach.Coach;
import com.springdemo.annotations.javaConfiguration.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {

        // read spring config java file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        Coach theCoach = context.getBean("pingPongCoach", Coach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call a method on the bean
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
