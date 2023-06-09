package com.ableneo.jdk11to17.ex11randomapi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    private static final int SEED = 123654;

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(SEED);

    @Test
    void constantSeedReturnsConstantValue() {
        assertThat(randomNumberGenerator.nextInt()).isEqualTo(1897113197);
    }

}