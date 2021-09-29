package com.learn.java.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

/**
 * Created by grijesh.
 */
public class DateFormatConverter {

    public static void main(String... args) {
        System.out.println(convertDate("12 05, 2015 - 01:13", DateFormats.FORMAT1.format).get());
    }

    private static Optional<LocalDateTime> convertDate(String dateInString, String pattern) {
        Optional<LocalDateTime> date;
        try {
            date = Optional.of(LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(pattern)));
        } catch (DateTimeParseException e) {
            throw e;
        }
        return date;
    }


}

