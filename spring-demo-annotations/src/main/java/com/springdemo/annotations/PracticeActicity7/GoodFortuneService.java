package com.springdemo.annotations.PracticeActicity7;

import com.springdemo.annotations.Fortune.FortuneService;

public class GoodFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Wishing you a good fortune for today's game";
    }
}
