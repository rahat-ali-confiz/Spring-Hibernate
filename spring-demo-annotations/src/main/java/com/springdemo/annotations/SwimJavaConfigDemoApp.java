package com.springdemo.annotations;


import com.springdemo.annotations.Coach.SwimCoach;
import com.springdemo.annotations.javaConfiguration.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {

        // read spring config java file
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call a method on the bean
        System.out.println(theCoach.getDailyFortune());

        // Call our new swim coach methods .... has the propes values injected

        System.out.println("email: "+theCoach.getEmail());
        System.out.println("team: "+theCoach.getTeam());
        // close the context
        context.close();
    }
}
