import sockets.SocketClientHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Main {
    private static Integer port;

    public static void main(String[] args) throws IOException {
        loadProperties();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started");
            while (true) {

                Socket socket = serverSocket.accept();
                new SocketClientHandler(socket);

            }
        }
    }

    private static void loadProperties() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
            port = Integer.parseInt(properties.getProperty("port"));
        } catch (IOException ex) {
            throw ex;
        }
    }
}
