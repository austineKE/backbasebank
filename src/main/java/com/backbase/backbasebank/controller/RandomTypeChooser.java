package com.backbase.backbasebank.controller;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomTypeChooser {

    public String getType(){
        Random random=new Random();
        int random_int= random.ints(1,3).findFirst().getAsInt();
        if (random_int == 1){
            return "okoa";
        }
        return "hekima";
    }
}
