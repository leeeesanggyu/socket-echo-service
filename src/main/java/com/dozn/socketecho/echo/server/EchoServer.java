package com.dozn.socketecho.echo.server;

import com.dozn.socketecho.crypt.AES128;
import lombok.extern.slf4j.Slf4j;

import javax.swing.text.html.Option;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

@Slf4j
public class EchoServer {

    private static final Queue<String> messageQueue = new LinkedList<>();
    private static final int maxQueueSize = 10;

    public static void on() {
        int port = 8081;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("[Echo Server]Echo Server is running on port = {}", port);

            Socket clientSocket = serverSocket.accept();

            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = reader.readLine();
                String decryptMessage = decryptMessage(clientMessage);
                log.info("[Echo Server] Received from client message: {}", clientMessage);
                log.info("[Echo Server] Decrypt message: {}", decryptMessage);

                messageQueue.add(decryptMessage);
                Optional<String> overQueueMessage = overSizeRemoveReturn();
                if (overQueueMessage.isPresent()) {
                    writer.println(decryptMessage + ", pollQueueMessage : " + overQueueMessage.get());
                } else {
                    writer.println(decryptMessage);
                }
            }
//            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Optional<String> overSizeRemoveReturn() {
        if (messageQueue.size() > maxQueueSize) {
            return Optional.ofNullable(messageQueue.poll());
        }
        return Optional.empty();
    }


    private static String decryptMessage(String clientMessage) {
        String key = "keykeykeykeykeykey";
        AES128 aes = new AES128(key);
        return aes.decrypt(clientMessage);
    }
}
