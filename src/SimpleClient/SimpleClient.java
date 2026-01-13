package SimpleClient;

import java.net.*;
import java.io.*;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        // 1. Connect to the server running on localhost at port 8080
        // Ensure SimpleServer is running before starting this!
        Socket socket = new Socket("localhost", 8080);
        System.out.println("Connected to server...");

        // 2. Setup output stream to send data to the server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Hello from Client!");
        System.out.println("Sent message to server.");

        // 3. Setup input stream to read the response from the server
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        // 4. Read and print the server's response
        String response = in.readLine();
        System.out.println("Server response: " + response);

        // 5. Close the connection
        socket.close();
    }
}