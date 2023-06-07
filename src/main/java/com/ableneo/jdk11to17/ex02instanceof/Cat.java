package com.ableneo.jdk11to17.ex02instanceof;

public class Cat extends Animal implements Meowable {
    @Override
    public void meow() {
        System.out.println("Meow!");
    }
}
