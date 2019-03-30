package dao;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Netzwerk {

    public void sendeAnServer(JSONObject jd) {

        System.out.println("Daten werden geschickt...");

        // nur ein Test
        System.out.println("Inhalt der JSON:");
        leseJSON(jd);

        // hier sollte die JSON an der Server geschickt werden
/*
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 1337);
            System.out.println(socket.getLocalSocketAddress() + ":" + socket.getLocalPort());

            System.out.println("Enter lines of text then Ctrl+D or Ctrl+C to quit");
            Scanner scanner = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                System.out.println(in.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
*/
    }

    // nur ein Test
    private void leseJSON(JSONObject jsonDatei) {

        System.out.println(jsonDatei.toString());

    }
}