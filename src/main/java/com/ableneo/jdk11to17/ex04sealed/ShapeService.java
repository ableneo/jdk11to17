package com.ableneo.jdk11to17.ex04sealed;

public class ShapeService {

    double computeArea(Shape shape) {
        if (shape instanceof Circle) {
            final double radius = ((Circle) shape).getRadius();
            return Math.PI * Math.pow(radius, 2);
        } else if (shape instanceof Rectangle) {
            final Rectangle rectangle = (Rectangle) shape;
            return rectangle.getA() * rectangle.getB();
        } else {
            throw new UnsupportedOperationException("Don't know how to compute area of shape " + shape.getClass().getSimpleName());
        }
    }

    double computeCircumference(Shape shape) {
        if (shape instanceof Circle) {
            final double radius = ((Circle) shape).getRadius();
            return 2 * Math.PI * radius;
        } else if (shape instanceof Rectangle) {
            final Rectangle rectangle = (Rectangle) shape;
            return 2 * (rectangle.getA() + rectangle.getB());
        } else {
            throw new UnsupportedOperationException("Don't know how to compute circumference of shape " + shape.getClass().getSimpleName());
        }
    }

}
