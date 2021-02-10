package model;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // EFFECTS: produces true if the date is in a leap year, false otherwise
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
        if ((month == 4 | month == 6 | month == 9 | month == 11) & (0 < day) & (day <= 30)) {
            return true;
        }
        if ((month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12)
                & (0 < day) & (day <= 31)) {
            return true;
        }
        if ((month == 2) & isLeapYear & (0 < day) & (day <= 29)) {
            return true;
        }
        return (month == 2) & (0 < day) & (day <= 28);
    }

    public int getYear() {
        return year;
    }

    // MODIFIES: this
    // EFFECTS: If year produces a valid date with month and day, sets this.year to year and returns true.
    // If the combination is invalid, date is not changed and returns false.
    public boolean setYear(int year) {
        Date newDate = new Date(year, this.month, this.day);
        if (newDate.isValidDate()) {
            this.year = year;
            return true;
        } else {
            return false;
        }
    }

    public int getMonth() {
        return month;
    }

    // MODIFIES: this
    // EFFECTS: If month produces a valid date with year and day, sets this.month to month and returns true.
    // If the combination is invalid, date is not changed and returns false.
    public boolean setMonth(int month) {
        Date newDate = new Date(this.year, month, this.day);
        if (newDate.isValidDate()) {
            this.month = month;
            return true;
        } else {
            return false;
        }
    }

    public int getDay() {
        return day;
    }

    // MODIFIES: this
    // EFFECTS: If day produces a valid date with month and year, sets this.day to day and returns true.
    // If the combination is invalid, date is not changed and returns false.
    public boolean setDay(int day) {
        Date newDate = new Date(this.year, this.month, day);
        if (newDate.isValidDate()) {
            this.day = day;
            return true;
        } else {
            return false;
        }
    }
}
