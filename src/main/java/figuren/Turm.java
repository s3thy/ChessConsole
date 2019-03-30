package figuren;

import spiel.Position;

public class Turm extends Spielfigur {

    public Turm() {
    }

    @Override
    public void nimmtPlatz(Position position) {
        System.out.print("T");
    }
}
