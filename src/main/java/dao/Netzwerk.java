package dao;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

public class Netzwerk {

    public void sendeAnServer(JSONObject jd) {

        int port = 1337;
        Socket socket = null;

        System.out.println("Daten werden geschickt...");

        try {
            socket = new Socket("localhost", port);
            startSocketHandler(socket, jd);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert socket != null;
            closeSocket(socket);
        }
    }

    private static void startSocketHandler(Socket socket, JSONObject jd) {

        try {
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            // String text = reader.readLine();
            // JSONObject jsonObject = new JSONObject();
            // jsonObject.put("message", "Hello World!");

            // writer.write(jsonObject.toString() + "\n");
            writer.write(jd.toString() + "\n");
            writer.flush();

            String s = reader.readLine();
            JSONObject jsonObject = new JSONObject(s);

            System.out.println("Received from server: \n" + jsonObject.toString(2));

        } catch (IOException e) {
            System.err.println(e);
        } finally {
            assert socket != null;
            closeSocket(socket);
        }
    }

    private static void closeSocket(Socket socket) {
        try {

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // nur ein Test
    private void leseJSON(JSONObject jsonDatei) {

        System.out.println(jsonDatei.toString());

    }
}