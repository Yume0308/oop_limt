package com.limt.Lib;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Utils {
    @NotNull
    public static Long generateUserID() {
        Random random = new Random();
        long min = 10000000000000000L;
        long max = 99999999999999999L;
        return random.nextLong((max - min) + 1) + min;
    }

    @NotNull
    public static Long generateBookID() {
        Random random = new Random();
        long min = 100000000000000000L;
        long max = 999999999999999999L;
        return random.nextLong((max - min) + 1) + min;
    }
}
