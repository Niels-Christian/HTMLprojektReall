package com.example.htmlprojektreal;

import java.io.*;
import java.net.*;
public class Connecting
{
    public static void main(String[] arg)
    {
        try {
            URL url = new URL("http://130.225.170.241:8080/hello/");
            InputStream inputStream = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s = bufferedReader.readLine();
            while (s != null)
            {
                System.out.println("received: "+s);
                s = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}