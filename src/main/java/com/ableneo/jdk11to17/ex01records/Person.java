package com.ableneo.jdk11to17.ex01records;

public record Person(String name, String surname, int age) {
    public Person {
        if (age < 0) throw new IllegalArgumentException("Age must not be negative");
        name = name.trim();
        surname = surname.trim();
    }
}

