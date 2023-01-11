package first;

import javax.swing.*;

public class Ablauf {
    private static Spiel spiel;

    public Ablauf() {
        this.spiel = new Spiel();
    }

    public static void main(String[] args) {

        Spieler aktuellerSpieler = spiel.getPit().getSpielerW();

        do {
            //spielbrett anzeigen
            for (int i = 0; i<8; i++){
                String zeile="";
                for (int k = 0; k<8; k++){
                    zeile = zeile + spiel.getPit().toStringAsArray()[i][k] + " ";
                }
                System.out.println(zeile);
            }

            //score anzeigen
            System.out.println("\rDer Aktuelle Score ist:");
            System.out.println(spiel.getPit().getSpielerW().getFarbe().toString() + ":  " + spiel.getPit().getSpielerW().getPunkte() + "Punkte");
            System.out.println(spiel.getPit().getSpielerB().getFarbe().toString() + ":  " + spiel.getPit().getSpielerB().getPunkte() + "Punkte");

            //akuteller spieler anzeigen + input erfragen + input checken und ggfs neu fragen + bewegen (intern) + Punkte hochzählen
            spiel.inputVomSpieler(aktuellerSpieler);

            if (aktuellerSpieler.getFarbe() == Farbe.W)
                aktuellerSpieler = spiel.getPit().getSpielerB();
            else if (aktuellerSpieler.getFarbe() == Farbe.B)
                aktuellerSpieler = spiel.getPit().getSpielerW();

        } while (aktuellerSpieler.hatGewonnen());

        System.out.println("Glückwunsch! "+aktuellerSpieler.getFarbe().toString() + " hat gewonnen." );
    }
}
