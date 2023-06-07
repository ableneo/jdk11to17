package com.ableneo.jdk11to17.ex03switch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class DateServiceTest {

    private final DateService dateService = new DateService();

    @ParameterizedTest
    @CsvSource({
            "2023-06-03     , WEEKEND",
            "2023-06-10     , WEEKEND",
            "2023-06-11     , WEEKEND",
            "2023-06-17     , WEEKEND",
            "2023-06-18     , WEEKEND",
            "2023-01-01     , WEEKEND",
            "2022-01-01     , WEEKEND",
            "2023-06-05     , WORKDAY",
            "2023-06-06     , WORKDAY",
            "2023-06-07     , WORKDAY",
            "2023-06-08     , WORKDAY",
            "2021-01-01     , HOLIDAY",
    })
    void returnsCorrectTypeOfDayForSaturdayOrSunday(String dateString, TypeOfDay expectedTypeOfDay) {
        final LocalDate localDate = LocalDate.parse(dateString);

        final TypeOfDay typeOfDay = dateService.getTypeOfDay(localDate);

        assertThat(typeOfDay).isEqualTo(expectedTypeOfDay);
    }
}