package com.limt.Lib;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Utils {
    @NotNull
    public static Integer generateUserID() {
        Random random = new Random();
        int min = 1000000;
        int max = 9999999;
        return random.nextInt((max - min) + 1) + min;
    }

    @NotNull
    public static Integer generateBookID(){
        Random random = new Random();
        int min = 100000000;
        int max = 999999999;
        return random.nextInt((max - min) + 1) + min;
    }
}
