package com.dozn.socketecho.echo.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class EchoServer {

    public static void on() {
        int port = 8081;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("[Echo Server]Echo Server is running on port = {}", port);

            Socket clientSocket = serverSocket.accept();

            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = reader.readLine();
                log.info("[Echo Server]Received from client: {}", clientMessage);

                // Echo the message back
                writer.println(clientMessage);
            }
//            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
