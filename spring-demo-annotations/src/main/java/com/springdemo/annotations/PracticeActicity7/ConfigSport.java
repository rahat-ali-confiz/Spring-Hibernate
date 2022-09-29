package com.springdemo.annotations.PracticeActicity7;

import com.springdemo.annotations.Coach.Coach;
import com.springdemo.annotations.Fortune.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSport {

    @Bean
    public FortuneService goodFortuneService(){
        return new GoodFortuneService();
    }

    @Bean
    public Coach footballCoach(){
        return new FootballCoach(goodFortuneService());
    }
}
