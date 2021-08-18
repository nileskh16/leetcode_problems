package com.plural.spring.fundamentals.tij.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppCommServer {

    private final ExecutorService executorService;

    public AppCommServer() {
        executorService = Executors.newCachedThreadPool();
    }

    public void listenAndTalk(int port) {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on " + port);
            while (true) {
                handleClient(server.accept());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (!executorService.isShutdown()) {
                executorService.shutdown();
            }
        }
    }

    public void handleClient(Socket client) {
        Runnable cl = new Runnable() {
            @Override
            public void run() {
                System.out.println("Received a connection from " + Thread.currentThread().getName());
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                     PrintWriter writer = new PrintWriter(client.getOutputStream(), true)) {
                    String line = null;
                    while (!(line = reader.readLine()).equalsIgnoreCase("EXIT")) {
                        System.out.printf("From Client -> %s%n", line);
                        writer.println(line);
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                } finally {
                    try {
                        client.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        executorService.execute(cl);
    }
}
