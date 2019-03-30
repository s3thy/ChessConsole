package figuren;

import spiel.Position;

public class Bauer extends Spielfigur {

    public Bauer() {
    }

    @Override
    public void nimmtPlatz(Position position) {
        System.out.print("B");
    }
}
