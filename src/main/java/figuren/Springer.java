package figuren;

import spiel.Position;

public class Springer extends Spielfigur {

    public Springer() {
    }

    @Override
    public void nimmtPlatz(Position position) {
        System.out.print("S");
    }
}
