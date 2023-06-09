package com.ableneo.jdk11to17.ex12npe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.fail;

class NpeGeneratorTest {

    private final NpeGenerator npeGenerator = new NpeGenerator();

    @Test
    void testGenerateObjectNpe() {
        try {
            npeGenerator.generateObjectNpe();
            fail("NPE was expected");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGenerateMethodReturnNpe() {
        try {
            npeGenerator.generateMethodReturnNpe();
            fail("NPE was expected");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testGenerateArrayAccessNpe() {
        try {
            npeGenerator.generateArrayAccessNpe();
            fail("NPE was expected");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGenerateFieldAccessNpe() {
        try {
            npeGenerator.generateFieldAccessNpe();
            fail("NPE was expected");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

}