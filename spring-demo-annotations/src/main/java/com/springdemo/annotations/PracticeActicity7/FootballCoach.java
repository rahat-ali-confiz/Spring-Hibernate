package com.springdemo.annotations.PracticeActicity7;

import com.springdemo.annotations.Coach.Coach;
import com.springdemo.annotations.Fortune.FortuneService;

public class FootballCoach implements Coach {

    private FortuneService fortuneService;

    public FootballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Do the drilling exercise for 1 hour";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
