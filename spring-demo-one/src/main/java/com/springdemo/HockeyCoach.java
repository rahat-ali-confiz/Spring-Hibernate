package com.springdemo;

public class HockeyCoach implements Coach {

    private FortuneService fortuneService;

    public HockeyCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    public HockeyCoach() {
    }

    @Override
    public String getDailyWorkout() {
        return "Working on my drilling skills";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
