package org.kybinfrastructure.dococt;

public class RequestHandler {
    private RequestHandler() {
    }

    public static String handle(String request) {
        return String.format("Your request: %s", request);
    }
}