package com.ableneo.jdk11to17.ex02instanceof;

import static com.ableneo.jdk11to17.ex02instanceof.DogBreed.CHIHUAHUA;
import static com.ableneo.jdk11to17.ex02instanceof.DogBreed.SHEPHERD;

/**
 * Causes an {@link Animal} to emit its sound, based on animal's type.
 * <p>
 * Animals make every sound they are capable of making. If an animal can make multiple types of sound,
 * it will make all of them.
 * <p>
 * The only exception are Chihuahuas ({@link DogBreed#CHIHUAHUA}). We don't let them bark, because our boss doesn't like the sound.
 */
public class AnimalVisitor {

    public void makeAnimalSound(Animal animal) {
        if (animal instanceof Barkable) {
            bark((Barkable) animal);
        }
        if (animal instanceof Meowable) {
            ((Meowable) animal).meow();
        }
    }

    private void bark(Barkable barkable) {
        if (barkable instanceof Dog && (CHIHUAHUA == ((Dog) barkable).getBreed())) {
            return;
        }
        barkable.bark();
    }
}
