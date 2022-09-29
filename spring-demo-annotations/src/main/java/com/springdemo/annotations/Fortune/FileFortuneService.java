package com.springdemo.annotations.Fortune;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component
public class FileFortuneService implements FortuneService{

    private String fileName = "src/main/resources/fortune-data.txt";
    private List<String> theFortunes;

    // create a random number generator
    private Random myRandom = new Random();

    public FileFortuneService() {

        System.out.println(">> FileFortuneService: inside default constructor");
    }

    @PostConstruct
    public void loadTheFortunesFile(){

        System.out.println(">> FileFortuneService: inside method loadTheFortunesFile");

        File theFile = new File(fileName);

        System.out.println("Reading fortunes from file: " + theFile);
        System.out.println("File exists: " + theFile.exists());

        // initialize array list
        theFortunes = new ArrayList();

        // read fortunes from file
        try (Scanner sc = new Scanner(new FileReader(theFile))) {

            String tempLine;

            while (sc.hasNext()) {
                tempLine = sc.nextLine();
                theFortunes.add(tempLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        // pick a random string from the array
        int index = myRandom.nextInt(theFortunes.size());

        String tempFortune = theFortunes.get(index);

        return tempFortune;
    }

}
