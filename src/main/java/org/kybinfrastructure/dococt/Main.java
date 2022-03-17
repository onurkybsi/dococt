package org.kybinfrastructure.dococt;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("dococt is running!");

        int portNumber = 8080;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (true) {
                new RequestProcessor(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}
