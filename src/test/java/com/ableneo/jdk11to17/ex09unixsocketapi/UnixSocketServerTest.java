package com.ableneo.jdk11to17.ex09unixsocketapi;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class UnixSocketServerTest {

    private static final String SOCKET_PATH = "/tmp/unixSocketServerTest.sock";

    @ParameterizedTest
    @CsvSource(delimiter = '|',
            value = {
                    "John Doe       | Hello, John Doe",
                    "Snow White     | Hello, Snow White"
            })
    void testSocketServer(String name, String expectedResponse) throws IOException, InterruptedException {
        final String canonicalName = UnixSocketServer.class.getCanonicalName();
        final String currentDir = System.getProperty("user.dir");
        final String javaMainClasspathDir = Paths.get(currentDir).resolve("build/classes/java/main").toString();
        final Process socketServer = new ProcessBuilder("java", "-cp", javaMainClasspathDir, canonicalName, SOCKET_PATH)
                .start();
        Thread.sleep(1000);

        final String response;
        try (final SocketChannel socketChannel = SocketChannel.open(StandardProtocolFamily.UNIX)) {
            socketChannel.configureBlocking(true);
            final UnixDomainSocketAddress socketAddress = UnixDomainSocketAddress.of(SOCKET_PATH);
            socketChannel.connect(socketAddress);
            UnixSocketServer.writeSocketMessage(socketChannel, name);
            response = UnixSocketServer.readSocketMessage(socketChannel);
        }

        socketServer.waitFor();
        assertThat(socketServer.exitValue()).isZero();
        assertThat(response).isEqualTo(expectedResponse);
    }

}