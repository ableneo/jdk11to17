package com.ableneo.jdk11to17.ex08processapi;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class OutputGeneratorTest {

    @ParameterizedTest
    @Timeout(5)
    @CsvSource(value = {
            "1      , o             , e",
            "5      , ooooo         , eeeee",
            "10     , oooooooooo    , eeeeeeeeee",
    })
    void testProcessApi(int n, String expectedOut, String expectedErr) throws IOException, InterruptedException {
        final String canonicalName = OutputGenerator.class.getCanonicalName();
        final String currentDir = System.getProperty("user.dir");
        final String javaMainClasspathDir = Paths.get(currentDir).resolve("build/classes/java/main").toString();
        final Process outputGenerator = new ProcessBuilder("java", "-cp", javaMainClasspathDir, canonicalName)
                .start();

        final String sysoutLine;
        final String syserrLine;
        try (
                final BufferedReader inputReader = outputGenerator.inputReader();
                final BufferedReader errorReader = outputGenerator.errorReader();
                final BufferedWriter outputWriter = outputGenerator.outputWriter()
        ) {
            outputWriter.write(Integer.toString(n));
            outputWriter.newLine();
            outputWriter.flush();
            sysoutLine = inputReader.readLine();
            syserrLine = errorReader.readLine();
        }

        outputGenerator.waitFor();
        assertThat(outputGenerator.exitValue()).isZero();
        assertThat(sysoutLine).isEqualTo(expectedOut);
        assertThat(syserrLine).isEqualTo(expectedErr);
    }

}