package springbyexamples.tcpserver;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@Test
public class TcpserverApplicationTests extends AbstractTestNGSpringContextTests {

    @Test
    public void contextLoads() throws IOException {

        Socket clientSocket = new Socket("localhost", 6666);

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //
        // Send a message TO the TcpServer
        //
        out.println("test1");

        //
        // Read the response sent back
        //
        String response = in.readLine();

        Assert.assertEquals(response, "received: test1");

    }

}
