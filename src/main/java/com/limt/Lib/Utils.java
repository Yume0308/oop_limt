package com.limt.Lib;

import org.jetbrains.annotations.NotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @NotNull
    public static String formatDatetime(String dateFormat, Date date) {
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }

    @NotNull
    public static Date convertStringToDatetime(String dateFormat, String dateString) throws ParseException {
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.parse(dateString);
    }
}
