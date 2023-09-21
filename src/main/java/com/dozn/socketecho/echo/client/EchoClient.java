package com.dozn.socketecho.echo.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

@Slf4j
public class EchoClient {

    public static void on() {
        String serverIP = "127.0.0.1";
        int serverPort = 8081;

        try (Socket socket = new Socket(serverIP, serverPort)) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter a message to send to the server (or 'exit' to quit): ");

                String message = scanner.nextLine();
                writer.println(message);

                String serverResponse = reader.readLine();
                System.out.println("[Echo Client] Received from server: " + serverResponse);
            }
        } catch (IOException e) {
            log.error("[Echo Client]socket send message error", e);
        }
    }
}
