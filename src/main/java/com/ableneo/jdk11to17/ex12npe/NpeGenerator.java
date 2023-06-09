package com.ableneo.jdk11to17.ex12npe;

@SuppressWarnings("all")
public class NpeGenerator {

    void generateObjectNpe() {
        String name = null;
        System.out.println(name.toLowerCase());
    }

    void generateMethodReturnNpe() {
        System.out.println(returnNull().toLowerCase());
    }

    void generateArrayAccessNpe() {
        String[][] strings = new String[10][10];
        System.out.println(strings[3][5].toLowerCase());
    }

    void generateFieldAccessNpe() {
        System.out.println(new Node().left.right.value);
    }

    private String returnNull() {
        return null;
    }

}
