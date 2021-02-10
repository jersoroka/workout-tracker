package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {
    private Date testDate;
    private Date testDateLeapYear;

    @BeforeEach
    void runBefore() {
        testDate = new Date(2021, 11, 9);
        testDateLeapYear = new Date(2020, 2, 29);
    }

    @Test
    void testDate() {
        testDate = new Date(2021, 2, 8);
        assertEquals(2021, testDate.getYear());
        assertEquals(2, testDate.getMonth());
        assertEquals(8, testDate.getDay());
    }

    @Test
    void testSetYearValid() {
        assertTrue(testDate.setYear(2011));
        assertEquals(2011, testDate.getYear());
    }

    @Test
    void testSetMonthValid() {
        assertTrue(testDate.setMonth(12));
        assertEquals(12, testDate.getMonth());
    }

    @Test
    void testSetDayValid() {
        assertTrue(testDate.setYear(31));
        assertEquals(31, testDate.getYear());
    }

    @Test
    void testSetYearInvalid() {
        assertFalse(testDateLeapYear.setYear(2021));
        assertEquals(2020, testDateLeapYear.getYear());
    }

    @Test
    void testSetMonthInvalid() {
        assertFalse(testDateLeapYear.setMonth(13));
        assertEquals(2, testDateLeapYear.getMonth());
    }

    @Test
    void testSetDayInvalid() {
        testDate.setDay(31);
        assertEquals(9, testDate.getDay());
    }

    @Test
    void testIsLeapYearDivides4Divides100DoesNotDivide400() {
        testDate.setYear(1800);
        assertFalse(testDate.isLeapYear());
    }

    @Test
    void testIsLeapYearDivides4DoesNotDivide100() {
        testDate.setYear(2012);
        assertTrue(testDate.isLeapYear());
    }

    @Test
    void testIsLeapYearDoesNoteDivide4() {
        testDate.setYear(2013);
        assertFalse(testDate.isLeapYear());

    }

    @Test
    void testIsLeapYearDivides4Divides100Divides400() {
        testDateLeapYear.setYear(2000);
        assertTrue(testDateLeapYear.isLeapYear());

    }

    @Test
    void testIsValidDate31DayMonth() {
        testDate.setMonth(10);

        Date testDay0 = new Date(2020, 10, 0);
        assertFalse(testDay0.isValidDate());

        testDate.setDay(1);
        assertTrue(testDate.isValidDate());

        testDate.setDay(21);
        assertTrue(testDate.isValidDate());

        testDate.setDay(31);
        assertTrue(testDate.isValidDate());

        Date testDay32 = new Date(2020, 10, 32);
        assertFalse(testDay32.isValidDate());

    }

    @Test
    void testIsValidDate30DayMonth() {
        Date testDay0 = new Date(2020, 11, 0);
        assertFalse(testDay0.isValidDate());

        testDate.setDay(1);
        assertTrue(testDate.isValidDate());

        testDate.setDay(11);
        assertTrue(testDate.isValidDate());

        testDate.setDay(30);
        assertTrue(testDate.isValidDate());

        Date testDay31 = new Date(2020, 11, 31);
        assertFalse(testDay31.isValidDate());

    }

    @Test
    void testIsValidDateFebruaryLeapYear() {
        Date testDay0 = new Date(2020, 2, 0);
        assertFalse(testDay0.isValidDate());

        testDateLeapYear.setDay(1);
        assertTrue(testDateLeapYear.isValidDate());

        testDateLeapYear.setDay(11);
        assertTrue(testDateLeapYear.isValidDate());

        testDateLeapYear.setDay(28);
        assertTrue(testDateLeapYear.isValidDate());

        testDateLeapYear.setDay(29);
        assertTrue(testDateLeapYear.isValidDate());

        Date testDay30 = new Date(2020, 2, 30);
        assertFalse(testDay30.isValidDate());

    }

    @Test
    void testIsValidDateFebruaryNotLeapYear() {
        Date testDay0 = new Date(2021, 2, 0);
        assertFalse(testDay0.isValidDate());

        testDateLeapYear.setDay(1);
        assertTrue(testDateLeapYear.isValidDate());

        testDateLeapYear.setDay(11);
        assertTrue(testDateLeapYear.isValidDate());

        testDateLeapYear.setDay(28);
        assertTrue(testDateLeapYear.isValidDate());

        Date testDay29 = new Date(2021, 2, 29);
        assertFalse(testDay29.isValidDate());

        Date testDay30 = new Date(2021, 2, 30);
        assertFalse(testDay30.isValidDate());

    }


}