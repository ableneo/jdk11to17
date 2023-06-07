package com.ableneo.jdk11to17.ex04sealed;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class ShapeServiceTest {

    private final ShapeService shapeService = new ShapeService();

    @ParameterizedTest
    @CsvSource(value = {
            "1,     3.1416",
            "2,     12.5664",
            "2.5,   19.635"
    })
    void computesCircleAreaCorrectlyRoundedTo4DP(double radius, double expectedArea) {
        final Circle circle = new Circle(radius);

        final double area = shapeService.computeArea(circle);

        final double roundedArea = (double) (Math.round(area * 10000)) / 10000;
        assertThat(roundedArea).isEqualTo(expectedArea, within(0.0001));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,     6.2832",
            "2,     12.5664",
            "2.5,   15.708"
    })
    void computesCircleCircumferenceCorrectlyRoundedTo4DP(double radius, double expectedCircumference) {
        final Circle circle = new Circle(radius);

        final double circumference = shapeService.computeCircumference(circle);

        final double roundedCircumference = (double) (Math.round(circumference * 10000)) / 10000;
        assertThat(roundedCircumference).isEqualTo(expectedCircumference, within(0.0001));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,     1,      1",
            "2,     3,      6",
            "2.5,   5.5,    13.75"
    })
    void computesRectangleAreaCorrectlyRoundedTo4DP(double a, double b, double expectedArea) {
        final Rectangle rectangle = new Rectangle(a, b);

        final double area = shapeService.computeArea(rectangle);

        final double roundedArea = (double) (Math.round(area * 10000)) / 10000;
        assertThat(roundedArea).isEqualTo(expectedArea, within(0.0001));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,     1,      4",
            "2,     3,      10",
            "2.5,   5.75,   16.5"
    })
    void computesRectangleCircumferenceCorrectlyRoundedTo4DP(double a, double b, double expectedCircumference) {
        final Rectangle rectangle = new Rectangle(a, b);

        final double circumference = shapeService.computeCircumference(rectangle);

        final double roundedCircumference = (double) (Math.round(circumference * 10000)) / 10000;
        assertThat(roundedCircumference).isEqualTo(expectedCircumference, within(0.0001));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,     1",
            "2,     4",
            "2.5,   6.25",
    })
    void computesSquareAreaCorrectlyRoundedTo4DP(double a, double expectedArea) {
        final Square square = new Square(a);

        final double area = shapeService.computeArea(square);

        final double roundedArea = (double) (Math.round(area * 10000)) / 10000;
        assertThat(roundedArea).isEqualTo(expectedArea, within(0.0001));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,     4",
            "2,     8",
            "2.5,   10",
    })
    void computesSquareCircumferenceCorrectlyRoundedTo4DP(double a, double expectedCircumference) {
        final Square square = new Square(a);

        final double circumference = shapeService.computeCircumference(square);

        final double roundedCircumference = (double) (Math.round(circumference * 10000)) / 10000;
        assertThat(roundedCircumference).isEqualTo(expectedCircumference, within(0.0001));
    }
}