package com.example.htmlprojektreal;
import java.io.*;
import java.net.*;
public class Connection
{
    public static void main(String[] arg)
    {
        try {
            Socket socket = new Socket("http://130.225.170.241:8080/hello/",8080);
            OutputStream out  = socket.getOutputStream();
            InputStream  in = socket.getInputStream();
            PrintWriter    printWriter  = new PrintWriter(out);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            printWriter.println("GET /index.html HTTP/0.9");
            printWriter.println("Host: http://130.225.170.241:8080/hello/");
            printWriter.println();
            printWriter.flush();               // send anmodning afsted til værten
            String s = bufferedReader.readLine();
            while (s != null)         // readLine() giver null når datastrømmen lukkes
            {
                System.out.println("received: "+s);
                s = bufferedReader.readLine();
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}