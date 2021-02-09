package model;

import java.util.ArrayList;
import java.util.List;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // EFFECTS: produces true if the date is a leap year, false otherwise
    // formula for leap year calculation from: https://www.mathsisfun.com/leap-years.html
    public boolean isLeapYear() {
        if (year % 4 == 0) {
            return !((year % 100 == 0) & (year % 400 != 0));
        } else {
            return false;
        }
    }

    // EFFECTS: produces true if the date is valid, false otherwise
    public boolean isValidDate() {
        boolean isLeapYear = this.isLeapYear();
        if ((month == 4 | month == 6 | month == 9 | month == 11) & (0 <= day) & (day <= 30)) {
            return true;
        }
        if ((month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12)
                & (0 <= day) & (day <= 31)) {
            return true;
        }
        if ((month == 2) & isLeapYear & (0 <= day) & (day <= 29)) {
            return true;
        }
        return (month == 2) & (0 <= day) & (day <= 28);
    }
}
