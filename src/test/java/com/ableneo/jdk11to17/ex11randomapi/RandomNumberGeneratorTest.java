package com.ableneo.jdk11to17.ex11randomapi;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    private static final int SEED = 123654;

    private final Random random = new Random(SEED);

    @Test
    void constantSeedReturnsConstantValue() {
        assertThat(random.nextInt()).isEqualTo(1897113197);
    }

}