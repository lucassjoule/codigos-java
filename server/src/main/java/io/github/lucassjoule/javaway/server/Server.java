package io.github.lucassjoule.javaway.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author lucasjoule
 */
public class Server {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(3000)) {
            System.out.println("iniciando..");

            while (true) {
                try (Socket client = server.accept()) {
                    System.out.println("conexão iniciada com:" + client.getInetAddress().getHostName());
                    InputStreamReader input = new InputStreamReader(client.getInputStream());
                    BufferedReader reader = new BufferedReader(input);
                    
                    String message = reader.readLine();
                    
                    System.out.println("Mensagem recebida!" + message);
                } catch (IOException e) {
                    System.out.println("erro ao iniciar a conexão!" + e);
                }
            }
        } catch (IOException e) {
            System.out.println("erro ao abrir porta!" + e);
        }
    }
}
