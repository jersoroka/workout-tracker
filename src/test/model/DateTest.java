package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    void testIsValidDate30DayMonth() {
        List<Integer> thirtyDayMonths = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            if ((i == 4) | (i == 6) | (i == 9) | (i == 11))
                thirtyDayMonths.add(i);
        }

        for (int month : thirtyDayMonths) {
            testDate.setMonth(month);

            Date testDay0 = new Date(2020, month, 0);
            assertFalse(testDay0.isValidDate());

            testDate.setDay(1);
            assertTrue(testDate.isValidDate());

            testDate.setDay(11);
            assertTrue(testDate.isValidDate());

            testDate.setDay(30);
            assertTrue(testDate.isValidDate());

            Date testDay31 = new Date(2020, month, 31);
            assertFalse(testDay31.isValidDate());
        }
    }

    @Test
    void testIsValidDate31DayMonth() {
        List<Integer> thirtyOneDayMonths = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            if ((i == 1) | (i == 3) | (i == 5) | (i == 7) | (i == 8) | (i == 10) | (i == 12))
                thirtyOneDayMonths.add(i);
        }

        for (int month : thirtyOneDayMonths) {
            testDate.setMonth(month);

            Date testDay0 = new Date(2020, month, 0);
            assertFalse(testDay0.isValidDate());

            testDate.setDay(1);
            assertTrue(testDate.isValidDate());

            testDate.setDay(11);
            assertTrue(testDate.isValidDate());

            testDate.setDay(31);
            assertTrue(testDate.isValidDate());

            Date testDay31 = new Date(2020, month, 32);
            assertFalse(testDay31.isValidDate());
        }
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


    @Test
    void testGetFormattedDate() {
        Date testDateSingleDigitMonthSingleDigitDay = new Date(2020, 7, 4);
        Date testDateDoubleDigitMonthDoubleDigitDay = new Date(2020, 11, 11);

        assertEquals("2021-11-09", testDate.formatToString());
        assertEquals("2020-02-29", testDateLeapYear.formatToString());
        assertEquals("2020-07-04", testDateSingleDigitMonthSingleDigitDay.formatToString());
        assertEquals("2020-11-11", testDateDoubleDigitMonthDoubleDigitDay.formatToString());
    }

    @Test
    void testSetYearValid() {
        assertTrue(testDate.setYear(2011));
        assertEquals(2011, testDate.getYear());
    }

    @Test
    void testSetYearInvalid() {
        assertFalse(testDateLeapYear.setYear(2021));
        assertEquals(2020, testDateLeapYear.getYear());
    }

    @Test
    void testSetMonthValid() {
        assertTrue(testDate.setMonth(12));
        assertEquals(12, testDate.getMonth());
    }

    @Test
    void testSetMonthInvalid() {
        assertFalse(testDateLeapYear.setMonth(13));
        assertEquals(2, testDateLeapYear.getMonth());
    }

    @Test
    void testSetDayValid() {
        assertTrue(testDate.setYear(31));
        assertEquals(31, testDate.getYear());
    }

    @Test
    void testSetDayInvalid() {
        testDate.setDay(31);
        assertEquals(9, testDate.getDay());
    }

}
