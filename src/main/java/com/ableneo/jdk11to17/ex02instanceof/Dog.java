package com.ableneo.jdk11to17.ex02instanceof;

public class Dog extends Animal implements Barkable {

    private final DogBreed breed;

    public Dog(DogBreed breed) {
        this.breed = breed;
    }

    @Override
    public void bark() {
        System.out.println("Woof!");
    }

    public DogBreed getBreed() {
        return breed;
    }
}
