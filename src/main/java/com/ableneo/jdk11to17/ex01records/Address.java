package com.ableneo.jdk11to17.ex01records;

public class Address {

    private final String streetName;
    private final String city;
    private final int houseNumber;
    private final State state;

    public Address(String streetName, String city, int houseNumber, State state) {
        this.streetName = streetName;
        this.city = city;
        this.houseNumber = houseNumber;
        this.state = state;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public State getState() {
        return state;
    }
}
