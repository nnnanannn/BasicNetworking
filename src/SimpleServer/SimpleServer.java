package SimpleServer;

import java.net.*;
import java.io.*;

public class SimpleServer {
    public static void main(String[] args) throws IOException {
        // 1. Create a server socket listening on port 8080
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server listening on port 8080...");

        // 2. Wait for a client to connect (blocking call)
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        // 3. Create input stream to read messages from the client
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        // 4. Read the message sent by client
        String message = in.readLine();
        System.out.println("Received: " + message);

        // 5. Create output stream to send a response back to the client
        // 'true' enables auto-flush so data is sent immediately
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Hello from server!");

        // 6. Clean up resources
        clientSocket.close();
        serverSocket.close();
    }
}