package com.ableneo.jdk11to17.ex05textblock;

public class TemplateEngine {

    private static final String HTML_TEMPLATE = """
            <html lang="en">
            <head>
                <title>E-Shop</title>
            </head>
            <body>
            <h1>Welcome, %s!</h1>
            </body>
            </html>""";

    public String getHtmlForUser(String username) {
        return HTML_TEMPLATE.formatted(username);
    }

}
