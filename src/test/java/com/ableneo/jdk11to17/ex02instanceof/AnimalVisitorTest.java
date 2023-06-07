package com.ableneo.jdk11to17.ex02instanceof;

import org.junit.jupiter.api.Test;

import static com.ableneo.jdk11to17.ex02instanceof.DogBreed.CHIHUAHUA;
import static com.ableneo.jdk11to17.ex02instanceof.DogBreed.TERRIER;
import static org.mockito.Mockito.*;

class AnimalVisitorTest {

    private final AnimalVisitor animalVisitor = new AnimalVisitor();

    @Test
    void callsBarkOnBarkableAnimal() {
        final Dog dog = spy(new Dog(TERRIER));
        final Supercat supercat = spy(new Supercat());

        animalVisitor.makeAnimalSound(dog);
        animalVisitor.makeAnimalSound(supercat);

        verify(dog).bark();
        verify(supercat).bark();
    }

    @Test
    void callsMeowOnMeowableAnimal() {
        final Cat cat = spy(new Cat());
        final Supercat supercat = spy(new Supercat());

        animalVisitor.makeAnimalSound(cat);
        animalVisitor.makeAnimalSound(supercat);

        verify(cat).meow();
        verify(supercat).meow();
    }

    @Test
    void callsBarkAndMeowOnBarkableAndMeowableAnimal() {
        final Supercat supercat = spy(new Supercat());

        animalVisitor.makeAnimalSound(supercat);

        verify(supercat).bark();
        verify(supercat).meow();
    }

    @Test
    void doesNotCallBarkOnChihuahua() {
        final Dog dog = spy(new Dog(CHIHUAHUA));

        animalVisitor.makeAnimalSound(dog);

        verify(dog, never()).bark();
    }
}