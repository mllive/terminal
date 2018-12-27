package com.terminal.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.terminal.client.service.TerminalService;

@SpringBootApplication
@ComponentScan(basePackages = { "com.terminal.client" })
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
		TerminalService service = new TerminalService();
		service.subscribeMessage("t1");
		service.subscribeMessage("t2");
	}

}
