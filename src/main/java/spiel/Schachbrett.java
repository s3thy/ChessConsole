package spiel;

import dao.Datenformat;
import dao.Netzwerk;
import figuren.*;
import org.json.JSONObject;

import java.util.HashMap;

public class Schachbrett {

    private int[][] feld;
    private HashMap<Position, Spielfigur> feldInhalt;

    public Schachbrett(int x, int y) {
        int m_Y = y + 1;
        int m_X = x + 1;
        feld = new int[m_Y][m_X];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                feld[i][j] = j;
            }
        }
    }

    public int[][] getFeldGroesse() {
        return feld;
    }

    // starte den geilen Scheiss
    public void init(HashMap<Position, Spielfigur> mapBelegung) {
        stelleFigurenAuf(mapBelegung);
        // macheSpielZug();
    }

    // zeichne Spielbrett auf der Konsole
    // private void stelleFigurenAuf(HashMap<Position, Spielfigur> mapBelegung) {
    private void stelleFigurenAuf(HashMap<Position, Spielfigur> mapBelegung) {
        // erstelle Brett
        feldInhalt = new HashMap<>();
        feldInhalt = mapBelegung;
        // erstelle Figuren
        Spielfigur bauer = new Bauer();
        Spielfigur turm = new Turm();
        Spielfigur springer = new Springer();
        Spielfigur laeufer = new Laeufer();
        Spielfigur koenigin = new Koenigin();
        Spielfigur koenig = new Koenig();
        // Aufbau des Spielbretts
        for (int i = 0; i < feld.length - 1; i++) {
            for (int j = 0; j < feld[j].length - 1; j++) {
                Position pos;
                if (i == 1 || i == 6) {
                    pos = new Position(i, j);
                    feldInhalt.put(pos, bauer); // ab in die Ha.ha.ha.ha.hashmap
                }
                // setze Turm
                if ((i == 0 && j == 0) || (i == 0 && j == 7) || (i == 7 && j == 0) || (i == 7 && j == 7)) {
                    pos = new Position(i, j);
                    feldInhalt.put(pos, turm);
                }
                // setze Springer
                if ((i == 0 && j == 1) || (i == 0 && j == 6) || (i == 7 && j == 1) || (i == 7 && j == 6)) {
                    pos = new Position(i, j);
                    feldInhalt.put(pos, springer);
                }
                // setze Laeufer
                if ((i == 0 && j == 2) || (i == 0 && j == 5) || (i == 7 && j == 2) || (i == 7 && j == 5)) {
                    pos = new Position(i, j);
                    feldInhalt.put(pos, laeufer);
                }
                // setze Koenigin
                if ((i == 0 || i == 7) && (j == 3)) {
                    pos = new Position(i, j);
                    feldInhalt.put(pos, koenigin);
                }
                // setze Koenig
                if ((i == 0 || i == 7) && (j == 4)) {
                    pos = new Position(i, j);
                    feldInhalt.put(pos, koenig);
                }
            }
        }
        // return feldInhalt;
    }

    // zeige Schachbrett mit aktueller Belegung
/*
    private void zeigeAlleFiguren() {
        System.out.print("       A      B      C      D      E      F      G      H");
        System.out.println();
        for (int i = 0; i < feld.length - 1; i++) {
            System.out.print("|" + i + "| ");
            for (int j = 0; j < feld[j].length - 1; j++) {
                Position pos = new Position(i, j);
                Spielfigur spf = feldInhalt.get(pos);
                if (feldIstBelegt(pos)) {
                    System.out.print("(" + i + "," + j + ")");
                    spf.nimmtPlatz(pos);
                    System.out.print(" ");
                }
                if (!feldIstBelegt(pos)) {
                    System.out.print("(" + i + "," + j + ")");
                    System.out.print("." + " ");
                }
            }
            System.out.println();
        }
    }
*/

/*    // Spieler waehlt Position/Figur und Ziel aus
    private void macheSpielZug() {
        while (true) {
            // zeigeAlleFiguren();
            Scanner input = new Scanner(System.in);
            System.out.println("Alte Position auswaehlen");
            System.out.print("X: ");
            int altePositionX = input.nextInt();
            if (altePositionX == 99) return;
            System.out.print("Y: ");
            int altePositionY = input.nextInt();
            if (altePositionY == 99) return;
            Position altePosition = new Position(altePositionX, altePositionY);
            if (!feldIstBelegt(altePosition)) {
                System.out.print("\nWo klickst du hin? Auf Feld " + altePosition.getX() + "," + altePosition.getY() + " steht nix.\n\n");
                continue;
            } else {
                System.out.println("Ausgewaehlt: " + this.getFigurAufFeld(altePosition).getClass().getSimpleName() + " auf " + altePosition.getX() + "," + altePosition.getY());
            }
            System.out.println("Neue Position auswaehlen");
            System.out.print("X: ");
            int neuePositionX = input.nextInt();
            if (neuePositionX == 99) return;
            System.out.print("Y: ");
            int neuePositionY = input.nextInt();
            if (neuePositionY == 99) return;
            Position neuePosition = new Position(neuePositionX, neuePositionY);
            bewegeFigur(altePosition, neuePosition);
            senden();
        }
    }*/

    // schiebe Figur von A nach B
    // public void bewegeFigur(Position alt, Position neu) {
    public HashMap<Position, Spielfigur> bewegeFigur(Spielfigur spf, Position alt, Position neu) {
        // zeigeAlleFiguren();
       /* Spielfigur spf = getFigurAufFeld(alt);
        System.out.print("\n\nBewege Figur von " + alt.getX() + "," + alt.getY() + " nach " + neu.getX() + "," + neu.getY() + "\n");
        System.out.println("Auf " + alt.getX() + "," + alt.getY() + " steht jetzt " + this.getFigurAufFeld(alt).getClass().getSimpleName());*/
        feldInhalt.remove(alt);
        // feldInhalt.put(neu, spf);
        feldInhalt.put(neu, spf);
/*        System.out.println("Auf " + neu.getX() + "," + neu.getY() + " steht jetzt " + this.getFigurAufFeld(neu).getClass().getSimpleName());
        System.out.println();
        System.out.println("******************* Naechster Spieler *********************");*/
        return feldInhalt;
    }

    // wer steht auf dem ausgewaehlten Feld?
    public Spielfigur getFigurAufFeld(Position p) {
        return feldInhalt.get(p);
    }

    // steht eine Figur auf dem ausgewaehlten Feld?
    public boolean feldIstBelegt(Position p) {
        return this.getFigurAufFeld(p) != null;
    }

    // Infos in JSON packen
    private JSONObject output(HashMap feldInhalt) {

        JSONObject out = new Datenformat();

        for (Object o : feldInhalt.keySet()) {
            Position p = (Position) o;
            out.put(p.getX() + "," + p.getY(), getFigurAufFeld(p).getClass().getSimpleName());
        }
        return out;
    }

    // schicke mal die Daten los
    public void senden() {

        System.out.println("Sende an Server...");
        Netzwerk n = new Netzwerk();
        try {
            n.sendeAnServer(output(feldInhalt));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
