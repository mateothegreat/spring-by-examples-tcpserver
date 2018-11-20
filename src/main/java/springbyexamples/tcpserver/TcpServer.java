package springbyexamples.tcpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {

        serverSocket = new ServerSocket(port);

        while (true) {

            clientSocket = serverSocket.accept();

            System.out.println(serverSocket.getInetAddress() + ": CONNECTED");

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message = in.readLine();

            out.println("received: " + message);

            System.out.println(serverSocket.getInetAddress() + ": " + message);

            clientSocket.close();

        }

    }

    public void stop() throws IOException {

        in.close();
        out.close();

        clientSocket.close();
        serverSocket.close();

    }

}
