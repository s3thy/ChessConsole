package dao;

import org.json.JSONObject;

// wird erstmal gar nit gebraucht
public class Datenformat extends JSONObject {

    public void zuJson(int posX, int posY, String typ) {

        JSONObject json = new JSONObject();
        json.put(posX + "," + posY, typ);
        System.out.println(json);
    }
}
