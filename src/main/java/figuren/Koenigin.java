package figuren;

import spiel.Position;

public class Koenigin extends Spielfigur {

    public Koenigin() {
    }

    @Override
    public void nimmtPlatz(Position position) {
        System.out.print("D");
    }
}
