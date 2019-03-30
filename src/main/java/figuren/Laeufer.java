package figuren;

import spiel.Position;

public class Laeufer extends Spielfigur {

    public Laeufer() {
    }

    @Override
    public void nimmtPlatz(Position position) {
        System.out.print("L");
    }
}
