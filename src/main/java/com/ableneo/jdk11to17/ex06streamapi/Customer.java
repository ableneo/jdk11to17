package com.ableneo.jdk11to17.ex06streamapi;

import java.util.Objects;

public class Customer {
    private final String name;
    private final String surname;

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
