package com.springdemo.annotations.Coach;

import com.springdemo.annotations.Coach.Coach;
import com.springdemo.annotations.Fortune.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    private FortuneService fortuneService;



    @Autowired
    public CricketCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Against the spin and slow balls";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
