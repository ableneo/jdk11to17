package com.ableneo.jdk11to17.ex01records;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomUtils.nextInt;

public class Excercise01Records {

    private static final int PEOPLE_COUNT = 10_000_000;

    public static void main(String[] args) throws IOException {
        final ArrayList<Person> people = new ArrayList<>(PEOPLE_COUNT);
        final State[] states = State.values();

        for (int i = 0; i < PEOPLE_COUNT; i++) {
            final State state = states[nextInt(0, states.length - 1)];
            final Address address = new Address(randomAlphabetic(10),
                    randomAlphabetic(8),
                    nextInt(1, 1000),
                    state);
            final Person person = new Person(randomAlphabetic(8), randomAlphabetic(8), nextInt(10, 99), address);
            people.add(person);
        }

        System.out.println("Data populated, force GC in visualVM and analyze memory now.");
        System.out.println("Then press ENTER to continue...");
        new BufferedReader(new InputStreamReader(System.in)).readLine();

        final long adultsCount = people.parallelStream().filter(person -> person.getAge() >= 18).count();
        System.out.println(String.format("Number of adults: %d", adultsCount));
    }
}
