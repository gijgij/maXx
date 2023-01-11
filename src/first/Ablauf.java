package first;

import javax.swing.*;

public class Ablauf {
    private static Spiel spiel;

    public Ablauf() {
        this.spiel = new Spiel();
    }

    public static void main(String[] args) {
        do {



        } while (spiel.checkForWinner());
    }
}
