package com.ableneo.jdk11to17.ex11randomapi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    private static final int SEED = 123654;

    private final RandomGenerator randomGenerator = new RandomGenerator(SEED);

    @Test
    void constantSeedReturnsConstantValue() {
        assertThat(randomGenerator.nextInt()).isEqualTo(1897113197);
    }

}