package com.ableneo.jdk11to17.ex12npe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NpeGeneratorTest {

    private final NpeGenerator npeGenerator = new NpeGenerator();

    @Test
    void testGenerateObjectNpe() {
        npeGenerator.generateObjectNpe();
    }

}