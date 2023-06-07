package com.ableneo.jdk11to17.ex04sealed;

public class ShapeService {

    double computeArea(Shape shape) {
        return switch (shape) {
            case Circle circle -> Math.PI * Math.pow(circle.getRadius(), 2);
            case Rectangle rectangle -> rectangle.getA() * rectangle.getB();
        };
    }

    double computeCircumference(Shape shape) {
        return switch (shape) {
            case Circle circle -> 2 * Math.PI * circle.getRadius();
            case Rectangle rectangle -> 2 * (rectangle.getA() + rectangle.getB());
        };
    }

}
