package figuren;

import spiel.Position;

public class Koenig extends Spielfigur {

    public Koenig() {
    }

    @Override
    public void nimmtPlatz(Position position) {
        System.out.print("K");
    }
}
