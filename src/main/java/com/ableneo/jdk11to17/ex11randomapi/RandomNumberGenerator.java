package com.ableneo.jdk11to17.ex11randomapi;

import java.util.Random;

public class RandomNumberGenerator {

    private final Random random;

    public RandomNumberGenerator(int seed) {
        random = new Random(seed);
    }

    public int nextInt() {
        return random.nextInt();
    }


}
