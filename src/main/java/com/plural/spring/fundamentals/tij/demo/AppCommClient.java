package com.plural.spring.fundamentals.tij.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AppCommClient {

    public void connectAndTalk(String hostname, int port) {
        try (Socket client = new Socket(hostname, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter writer = new PrintWriter(client.getOutputStream(), true)) {
            System.out.println("Connected to server on port " + port);
            writer.println("Hello server");
            int count = 5;
            while (count-- > 0) {
                String message = reader.readLine();
                System.out.printf("From server -> %s%n", message);
                writer.println(message);
            }
            writer.println("EXIT");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
