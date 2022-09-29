package com.springdemo.annotations.Fortune;

import org.springframework.stereotype.Component;
import java.util.Random;



@Component
public class RandomFortuneService {

    private String[] data ={
            "Today is your lucky day.",
            "Beware of the wolf.",
            "An apple a day keeps the doctor away.",
            "A bird in hand is better than two in a bush."
    };

    private Random myRandom = new Random();


    public String getFortune() {
        int index = myRandom.nextInt(data.length);

        String tempFortune = data[index];
        return tempFortune;
    }
}
