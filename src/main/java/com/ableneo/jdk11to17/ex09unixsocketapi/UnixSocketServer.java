package com.ableneo.jdk11to17.ex09unixsocketapi;

import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UnixSocketServer {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IllegalArgumentException("Socket path was not provided");
        }
        final Path socketPath = Paths.get(args[0]);
        final UnixDomainSocketAddress socketAddress = UnixDomainSocketAddress.of(socketPath);
        try (final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open(StandardProtocolFamily.UNIX)) {
            serverSocketChannel.configureBlocking(true);
            Files.deleteIfExists(socketPath);
            serverSocketChannel.bind(socketAddress);
            try (final SocketChannel socketChannel = serverSocketChannel.accept()) {
                final String message = readSocketMessage(socketChannel);
                writeSocketMessage(socketChannel, "Hello, " + message);
            }
        } finally {
            Files.deleteIfExists(socketPath);
        }
    }

    static String readSocketMessage(SocketChannel socketChannel) throws IOException {
        final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        final int readBytes = socketChannel.read(byteBuffer);
        byteBuffer.flip();
        final byte[] bytes = new byte[readBytes];
        byteBuffer.get(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    static void writeSocketMessage(SocketChannel socketChannel, String message) throws IOException {
        final byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        final ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        socketChannel.write(byteBuffer);
    }
}
