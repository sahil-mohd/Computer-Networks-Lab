import java.io.*;
import java.net.*;
/**
 * Write a description of class EchoServer here.
 * 
 * @author Mohammed Sahil
 */
public class EchoServer
{
    /**
     * An example of a method - replace this comment with your own
     * 
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(6789);
        } catch (IOException e) {
            System.err.println("Could not listen on port 6789");
            System.exit(1);
        }

        Socket clientSocket = null;
        System.out.println("Waiting for connection........");
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed");
            System.exit(1);
        }

        System.out.println("Connection successful");
        System.out.println("Waiting for input");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;

        while((inputLine = in.readLine()) != null) {
            System.out.println("Server: " + inputLine);
            out.println(inputLine);

            if(inputLine.equals("Bye")) 
                break;
        }

        out.close();
        in.close();

        clientSocket.close();
        serverSocket.close();

    }
}
