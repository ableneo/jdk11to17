package com.ableneo.jdk11to17.ex11randomapi;

import org.junit.jupiter.api.Test;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    private static final int SEED = 123654;

    @Test
    void constantSeedReturnsConstantValue() {
        final RandomGenerator randomGenerator = RandomGeneratorFactory.getDefault().create(SEED);

        assertThat(randomGenerator.nextInt()).isEqualTo(715378305);
    }

    @Test
    void jumpWithConstantSeedReturnsConstantValue() {
        RandomGeneratorFactory<RandomGenerator.JumpableGenerator> factory = RandomGeneratorFactory.of("Xoshiro256PlusPlus");
        final RandomGenerator.JumpableGenerator jumpableGenerator = factory.create(SEED);

        jumpableGenerator.jump();
        assertThat(jumpableGenerator.nextInt()).isEqualTo(-359988068);
    }

}