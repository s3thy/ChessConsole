package applikation;

import figuren.Spielfigur;
import spiel.Position;
import spiel.Schachbrett;

import java.util.HashMap;

public class Main {



    public static void main(String[] args) {
        // starte Spiel
        // Schachbrett brett = new Schachbrett(8,8);
        // brett.init();
        // new Schachbrett(8, 8).init();

        // MVC
        HashMap<Position,Spielfigur> mapBelegung = new HashMap<>();
        Schachbrett brett = new Schachbrett(8,8);
        brett.init(mapBelegung);
        new View(mapBelegung,brett);

    }
}
