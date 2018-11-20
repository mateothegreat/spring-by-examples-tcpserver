package springbyexamples.tcpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpClientHandler {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public TcpClientHandler(Socket socket) {

        this.clientSocket = socket;

    }

    public void run() throws IOException {

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;

        while ((inputLine = in.readLine()) != null) {

            out.println("received: " + inputLine);

        }

        in.close();
        out.close();
        clientSocket.close();

    }

}
