package com.ableneo.jdk11to17.ex02instanceof;

public class Supercat extends Animal implements Barkable, Meowable {
    @Override
    public void bark() {
        System.out.println("Wooeoow!");
    }

    @Override
    public void meow() {
        System.out.println("Meooof!");
    }
}
