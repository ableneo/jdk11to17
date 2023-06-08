package com.ableneo.jdk11to17.ex08processapi;

import java.util.Scanner;

public class OutputGenerator {

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int charCount = scanner.nextInt();
            System.out.println("o".repeat(charCount));
            System.err.println("e".repeat(charCount));
        }
    }
}
