package com.springdemo.annotations.Coach;


import com.springdemo.annotations.Fortune.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component

public class TennisCoach implements Coach {

    // Field Injection
    @Autowired
    private FortuneService fortuneService;

    // define a default constructor
    public TennisCoach() {
       // System.out.println(">> TennisCoach: inside default constructor");
    }

    // define a setter method
	/*
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
	}
	*/

    /*
	@Autowired
	public TennisCoach(@Qualifier(value = "happyFortuneService") FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
     */

    // Define my init method
//    @PostConstruct
//    public void doMyStartupStuff(){
//        System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
//    }
//
//    // Define my destroy method
//    @PreDestroy
//    public void doMyCleanupStuff(){
//        System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
//    }


    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
