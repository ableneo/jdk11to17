package com.ableneo.jdk11to17.ex01records;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonTest {

    public static final String NAME = "Name";
    public static final String SURNAME = "Surname";
    public static final int AGE = 42;

    @Test
    void personGettersReturnCorrectValues() {
        final Person person = new Person(NAME, SURNAME, AGE);

        assertThat(person.name()).isEqualTo(NAME);
        assertThat(person.surname()).isEqualTo(SURNAME);
        assertThat(person.age()).isEqualTo(AGE);
    }

    @Test
    void twoSamePersonsAreEqual() {
        final Person person = new Person(NAME, SURNAME, AGE);
        final Person person2 = new Person(NAME, SURNAME, AGE);

        assertThat(person).isEqualTo(person2);
    }

    @Test
    void twoSamePersonsHaveSameHashCode() {
        final Person person = new Person(NAME, SURNAME, AGE);
        final Person person2 = new Person(NAME, SURNAME, AGE);

        assertThat(person).hasSameHashCodeAs(person2);
    }

    @Test
    void twoDifferentPersonsAreNotEqual() {
        final Person person = new Person(NAME, SURNAME, AGE);
        final Person person2 = new Person(NAME + NAME, SURNAME + SURNAME, AGE * 2);

        assertThat(person).isNotEqualTo(person2);
    }

    @Test
    void personCanNotHaveNegativeAge() {
        assertThatThrownBy(() -> new Person(NAME, SURNAME, -1)).isInstanceOf(IllegalArgumentException.class);
    }
}