package com.ableneo.jdk11to17.ex10filesapi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static org.assertj.core.api.Assertions.assertThat;

class FilesMismatchTest {

    @ParameterizedTest
    @CsvSource(value = {
            "HELLO      , HELLO         , -1",
            "HELLO      , HELO          , 3",
            "HELLO      , HELLO WORLD   , 5",
    })
    void findsMismatch(String file1String, String file2String, int expectedPosition) throws IOException {

        Path file1 = null;
        Path file2 = null;
        try {
            file1 = Files.createTempFile(null, null);
            file2 = Files.createTempFile(null, null);
            Files.writeString(file1, file1String, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
            Files.writeString(file2, file2String, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);

            final long mismatch = Files.mismatch(file1, file2);
            assertThat(mismatch).isEqualTo(expectedPosition);
        } finally {
            if (file1 != null) {
                Files.deleteIfExists(file1);
            }
            if (file2 != null) {
                Files.deleteIfExists(file2);
            }
        }
    }
}