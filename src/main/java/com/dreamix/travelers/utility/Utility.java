package com.dreamix.travelers.utility;

import java.time.LocalDateTime;

public class Utility {
    public static Integer stringToInteger(String number) {
        Integer intValue = null;
        try {
            intValue = Integer.parseInt(number);
        } catch (NumberFormatException e){
            System.out.println("OOOPS! " + number + " cannot be converted to int");
        }
        return intValue;
    }

    public static Long stringToLong(String number) {
        Long longValue = null;
        try {
            longValue = Long.parseLong(number);
        } catch (NumberFormatException e){
            System.out.println("OOOPS! " + number + " cannot be converted to int");
        }
        return longValue;
    }

    public static LocalDateTime stringToLocalDateTime(String dateAsString) {
        LocalDateTime date = null;
        try {
            date = LocalDateTime.parse(dateAsString);
        } catch (Exception e) {
            System.out.println("OOOPS! " + dateAsString + " cannot be converted to date");
        }
        return date;
    }
}
