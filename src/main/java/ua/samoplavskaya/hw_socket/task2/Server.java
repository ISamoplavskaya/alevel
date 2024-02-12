package ua.samoplavskaya.hw_socket.task2;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(3232)) {
            System.out.println("The server is running. Waiting for connections...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    String message = readMessageFromSocket(clientSocket);
                    printMessage(clientSocket, message);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readMessageFromSocket(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.readLine();
    }

    public static void printMessage(Socket socket, String message) {
        InetAddress clientAddress = socket.getInetAddress();
        System.out.print(LocalDateTime.now().format(TIME_FORMATTER) + " ");
        System.out.printf("[%s]", clientAddress.getHostAddress());
        System.out.println(" -- " + message);
    }
}
