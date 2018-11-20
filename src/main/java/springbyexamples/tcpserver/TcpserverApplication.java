package springbyexamples.tcpserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TcpserverApplication {

    private static int PORT = 6666;

    public static void main(String[] args) {

        TcpServer server = new TcpServer();

        System.out.println("Started TcpServer on port " + PORT);
        
        try {

            server.start(PORT);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
