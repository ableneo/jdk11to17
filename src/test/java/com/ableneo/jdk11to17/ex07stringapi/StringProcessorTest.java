package com.ableneo.jdk11to17.ex07stringapi;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringProcessorTest {

    private static final String HTML_TEMPLATE = """
            <html lang="en">
            <head>
                <title>E-Shop</title>
            </head>
            <body>
            <h1>Welcome, John Doe!</h1>
            </body>
            </html>
            """;

    private static final String HTML_TEMPLATE_INDENTED_BY_2 = """
              <html lang="en">
              <head>
                  <title>E-Shop</title>
              </head>
              <body>
              <h1>Welcome, John Doe!</h1>
              </body>
              </html>
            """;

    private static final String HTML_TEMPLATE_UNINDENTED_BY_2 = """
            <html lang="en">
            <head>
              <title>E-Shop</title>
            </head>
            <body>
            <h1>Welcome, John Doe!</h1>
            </body>
            </html>
            """;

    private static final String HTML_TEMPLATE_UNINDENTED_AND_INDENTED_BY_2 = """
              <html lang="en">
              <head>
                <title>E-Shop</title>
              </head>
              <body>
              <h1>Welcome, John Doe!</h1>
              </body>
              </html>
            """;

    @Test
    void testStringIndentAndUnindent() {
        final String indented = HTML_TEMPLATE.indent(2);
        final String unindented = indented.indent(-2);

        assertThat(indented).isEqualTo(HTML_TEMPLATE_INDENTED_BY_2);
        assertThat(unindented).isEqualTo(HTML_TEMPLATE);
    }

    @Test
    void testStringUnindentAndIndent() {
        final String unindented = HTML_TEMPLATE.indent(-2);
        final String indented = unindented.indent(2);

        assertThat(unindented).isEqualTo(HTML_TEMPLATE_UNINDENTED_BY_2);
        assertThat(indented).isEqualTo(HTML_TEMPLATE_UNINDENTED_AND_INDENTED_BY_2);
    }

    @Test
    void testTransformParseInt() {
        final int transformed = "42".transform(Integer::parseInt);

        assertThat(transformed).isEqualTo(42);
    }

    @Test
    void testTransformArbitraryFunction() {
        final String transformed = "Hello".transform(s -> s + ", world!");

        assertThat(transformed).isEqualTo("Hello, world!");
    }

}