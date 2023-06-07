package com.ableneo.jdk11to17.ex03switch;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class DateService {

    /**
     * Get the type of day.
     * <p>
     * For Saturday and Sunday, return {@link TypeOfDay#WEEKEND} unconditionally.
     * For Monday to Friday, return {@link TypeOfDay#WORKDAY} if not stated otherwise.
     * <p>
     * For 1.1. return {@link TypeOfDay#HOLIDAY}
     *
     * @param date
     * @return
     */
    public TypeOfDay getTypeOfDay(LocalDate date) {
        final DayOfWeek dayOfWeek = date.getDayOfWeek();
        switch (dayOfWeek) {
            case SATURDAY:
            case SUNDAY:
                return TypeOfDay.WEEKEND;
            default:
                if (date.getDayOfMonth() == 1 && date.getMonth() == Month.JANUARY) {
                    return TypeOfDay.HOLIDAY;
                } else {
                    return TypeOfDay.WORKDAY;
                }
        }
    }

}
