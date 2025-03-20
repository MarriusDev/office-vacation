package com.example.VacationOffice;

import java.time.LocalDate;

public class VacationManager {

    private final HolidayCalculator holidayCalculator = new HolidayCalculator();

    public double calculateRemainingVacation(LocalDate start, LocalDate end, double balance) {
        double mondayToThursday = 8.25;
        double friday = 6.5;

        while (!start.isAfter(end)) {
            if (isHoliday(start) || start.getDayOfWeek().getValue() >= 6) {
                start = start.plusDays(1);
                continue;
            }

            double dailyHours = (start.getDayOfWeek().getValue() == 5) ? friday : mondayToThursday;

            balance -= dailyHours;

            start = start.plusDays(1);
        }
        return balance;
    }

    public boolean isHoliday(LocalDate date) {
        return (this.holidayCalculator.getHolidays(date).contains(date));
    }

}
