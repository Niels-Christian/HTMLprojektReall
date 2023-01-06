import java.io.*;
import java.net.*;

public class PythonConnector {
    public static void main(String args[]) throws Exception {
        String fromClient;
        String toClient;

        ServerSocket server = new ServerSocket(8080);
        System.out.println("wait for connection on port 8080");

        boolean run = true;
        while(run) {
            Socket client = server.accept();
            System.out.println("got connection on port 8080");
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);

            String ECGInput;
            while ((ECGInput = in.readLine()) != null) {
                System.out.println("received: " + ECGInput);
                }
/*
            String ECGInput;
                ECGInput = in.readLine();
                System.out.println("received: " + ECGInput);


            String userInput;
            while ((userInput = in.readLine()) != null) {
                out.println(userInput);
                System.out.println("Next line: " + in.readLine());
            }
*/
            client.close();
            run = false;
            System.out.println("socket closed");

        }
    }
}