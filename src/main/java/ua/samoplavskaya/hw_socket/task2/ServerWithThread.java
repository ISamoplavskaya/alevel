package ua.samoplavskaya.hw_socket.task2;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerWithThread {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final int THREAD_POOL_NUM = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_NUM);
        try (ServerSocket serverSocket = new ServerSocket(3232)) {
            System.out.println("The server is running. Waiting for connections...");

            while (true) {
                executorService.execute(() -> {
                    try (Socket clientSocket = serverSocket.accept()) {
                        try {
                            handleClientRequest(clientSocket);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }

    private static void handleClientRequest(Socket clientSocket) throws IOException {
        String message = readMessageFromSocket(clientSocket);
        printMessage(clientSocket, message);
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
