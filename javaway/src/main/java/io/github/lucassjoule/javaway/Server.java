package io.github.lucassjoule.javaway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int port;
	
	public Server(int port) {
		this.port = port;
	}
	
	public Socket aceitarCliente() {
		try(ServerSocket server = new ServerSocket(port)){
			return server.accept();
			
		} catch (IOException e) {
			System.out.println("erro ao abrir!" + e);
			return null;
		}
		
	}
	
	private String receberMensagem(Socket client) {
		try {
			InputStreamReader reader = new InputStreamReader(client.getInputStream());
			BufferedReader input = new BufferedReader(reader);
			return input.readLine();
			
		} catch (Exception e) {
			System.out.println("erro ao receber!" + e);
			return null;
		}
	}
		public void imprimirMensagemRecebida(Socket client) {
			String message = receberMensagem(client);
			System.out.println("mensagem recebida! " + message);
		}
	}
	
	
	
	
	


