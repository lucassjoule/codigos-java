package io.github.lucassjoule.javaway;

import java.net.Socket;

public class Client {
	private Socket client;
	private int port;
	
	
	public Client(Socket client, int port) {
		this.client = client;
		this.port = port;
	}
	
	public String returnClientHostName() {
		return client.getInetAddress().getHostAddress();
	}


	public void enviarMensagem() {
		
	}
}
