package com.example.tp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void leapYear_cases() {
        assertTrue(DateUtils.isLeapYear(2000)); // divisible par 400
        assertFalse(DateUtils.isLeapYear(1900)); // divisible par 100 seulement
        assertTrue(DateUtils.isLeapYear(2024)); // divisible par 4 seulement
        assertFalse(DateUtils.isLeapYear(2023));
    }
}
