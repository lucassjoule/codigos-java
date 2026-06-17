package io.github.lucassjoule.javaway;


public class App {
	public static void main(String[] args) {
		int port = 3011;
		Server server = new Server(port);
		Client client;
		System.out.println("escutando...");
		while (true) {

			client = new Client(server.aceitarCliente(), port);
			System.out.println("ouvindo... nome:" + client.returnClientHostName());
		}

	}
}
