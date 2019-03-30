package applikation;

import figuren.Spielfigur;
import spiel.Position;
import spiel.Schachbrett;

import java.util.HashMap;
import java.util.Scanner;

class View {

    private Schachbrett board;

    View(HashMap<Position, Spielfigur> mapBelegung, Schachbrett brett) {
        board = brett;
        zeichneBrett(mapBelegung, board);
        macheSpielZug(mapBelegung);
/*        int[][] size = board.getFeldGroesse();
        int x = size.length;
        int y = size.length;
        board = new Schachbrett(x, y);*/

    }

    private void zeichneBrett(HashMap<Position, Spielfigur> map, Schachbrett brett) {

        // zeichne Brett
        this.board = brett;
        int[][] feld = new Schachbrett(8, 8).getFeldGroesse();

        System.out.print("       A      B      C      D      E      F      G      H");
        System.out.println();
        for (int i = 0; i < feld.length - 1; i++) {
            System.out.print("|" + i + "| ");
            for (int j = 0; j < feld[j].length - 1; j++) {
                Position pos = new Position(i, j);
                Spielfigur spf = map.get(pos);
                if (board.feldIstBelegt(pos)) {
                    System.out.print("(" + i + "," + j + ")");
                    spf.nimmtPlatz(pos);
                    System.out.print(" ");
                }
                if (!board.feldIstBelegt(pos)) {
                    System.out.print("(" + i + "," + j + ")");
                    System.out.print("." + " ");
                }
            }
            System.out.println();
        }
    }

/*    // steht eine Figur auf dem ausgewaehlten Feld?
    private boolean feldIstBelegt(Position p, HashMap<Position, Spielfigur> map) {
        return this.getFigurAufFeld(p, map) != null;
    }*/

/*    // wer steht auf dem ausgewaehlten Feld?
    private Spielfigur getFigurAufFeld(Position p, HashMap<Position, Spielfigur> map) {
        return map.get(p);
    }*/

    // Spieler waehlt Position/Figur und Ziel aus
    private void macheSpielZug(HashMap<Position, Spielfigur> map) {
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
            if (!board.feldIstBelegt(altePosition)) {
                System.out.print("\nWo klickst du hin? Auf Feld " + altePosition.getX() + "," + altePosition.getY() + " steht nix.\n\n");
                continue;
            } else {
                System.out.println("Ausgewaehlt: " + board.getFigurAufFeld(altePosition).getClass().getSimpleName() + " auf " + altePosition.getX() + "," + altePosition.getY());
            }
            System.out.println("Neue Position auswaehlen");
            System.out.print("X: ");
            int neuePositionX = input.nextInt();
            if (neuePositionX == 99) return;
            System.out.print("Y: ");
            int neuePositionY = input.nextInt();
            if (neuePositionY == 99) return;
            Position neuePosition = new Position(neuePositionX, neuePositionY);
            // wenn Zug gemacht werden soll
            Spielfigur spf = board.getFigurAufFeld(altePosition);
/*            System.out.print("\n\nBewege Figur von " + altePosition.getX() + "," + altePosition.getY() + " nach " + altePosition.getX() + "," + altePosition.getY() + "\n");
            System.out.println("Auf " + altePosition.getX() + "," + altePosition.getY() + " steht jetzt " + this.getFigurAufFeld(altePosition, map).getClass().getSimpleName());*/
            zeichneBrett(board.bewegeFigur(spf, altePosition, neuePosition), board);
/*            System.out.println("Auf " + neuePosition.getX() + "," + neuePosition.getY() + " steht jetzt " + this.getFigurAufFeld(neuePosition, map).getClass().getSimpleName());
            System.out.println();
            System.out.println("******************* Naechster Spieler *********************");*/
            board.senden();
        }
    }

}
