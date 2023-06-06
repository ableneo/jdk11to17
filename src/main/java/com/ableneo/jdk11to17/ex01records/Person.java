package com.ableneo.jdk11to17.ex01records;

public class Person implements HasAge {

    private final String name;
    private final String surname;
    private final int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int getAge() {
        return age;
    }
}

