package org.kybinfrastructure.dococt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestProcessor extends Thread {
    private Socket socket = null;

    public RequestProcessor(Socket socket) {
        super("RequestExecutor");
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));) {

            String inputLine;
            String outputLine;
            while ((inputLine = in.readLine()) != null) {
                outputLine = RequestHandler.handle(inputLine);
                out.println(outputLine);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
