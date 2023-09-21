package com.dozn.socketecho;

import com.dozn.socketecho.echo.client.EchoClient;
import com.dozn.socketecho.echo.server.EchoServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocketEchoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocketEchoApplication.class, args);

		if (args[0].equals("server")) {
			EchoServer.on();
		} else {
			EchoClient.on();
		}
	}
}
