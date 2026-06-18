package io.github.lucassjoule.javaway.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author lucasjoule
 */
public class Client {

    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", 3000)) {
            System.out.println("conectando...");
            enviarMensagem(client);
            
        } catch (IOException e) {
            System.out.println("erro ao conectar!!" + e);
        }
    }

    public static void enviarMensagem(Socket client) {
        try (PrintWriter writer = new PrintWriter(client.getOutputStream(), true)) {
            writer.println(obterMensagem());
            System.out.println("mensagem enviada!");
        } catch (IOException e) {
            System.out.println("erro ao enviar a mensagem!" + e);
        }
    }

    private static String obterMensagem() {
        String message;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("insira a mensagem que queira enviar ao servidor:");
            message = scan.nextLine();
        }
        return message;
       
    }
}
