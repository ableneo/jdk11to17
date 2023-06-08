package com.ableneo.jdk11to17.ex05textblock;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class TemplateEngineTest {

    private static final String USERNAME = "John Doe";
    private static final String EX_05_TEXTBLOCK_EXPECTED_HTML = "ex05textblock/expected.html";

    private final TemplateEngine templateEngine = new TemplateEngine();

    @Test
    void formatsTemplateCorrectly() {
        final String html = templateEngine.getHtmlForUser(USERNAME);

        final String expectedHtml = readFile();
        assertThat(html).isEqualTo(expectedHtml);
    }

    private String readFile() {
        final URL url = Objects.requireNonNull(getClass().getClassLoader().getResource(EX_05_TEXTBLOCK_EXPECTED_HTML), "File not found " + EX_05_TEXTBLOCK_EXPECTED_HTML);
        try {
            final Path path = Paths.get(url.toURI());
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}