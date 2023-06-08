package com.ableneo.jdk11to17.ex05textblock;

public class TemplateEngine {

    private static final String HTML_TEMPLATE = "<html lang=\"en\">\n" +
            "  <head>\n" +
            "      <title>E-Shop</title>\n" +
            "  </head>\n" +
            "  <body>\n" +
            "  <h1>Welcome, %s!</h1>\n" +
            "  </body>\n" +
            "  </html>";

    public String getHtmlForUser(String username) {
        return String.format(HTML_TEMPLATE, username);
    }

}
