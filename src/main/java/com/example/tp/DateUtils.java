package com.example.tp;

public class DateUtils {
    /** Année bissextile (Calendrier grégorien). */
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) return false;
        if (year % 100 != 0) return true;
        return year % 400 == 0;
    }
}
