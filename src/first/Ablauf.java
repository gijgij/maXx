package first;

/**
 * @author Izabela Almeida, Giovanna Janeiro, Julia Keck, Ann-Katrin Schließus
 * */
public class Ablauf {



    public static void main(String[] args) {

        Spiel spiel = new Spiel();

        //Spielbeginn Dialog
        System.out.println("Wer am schnellsten über 53 Punkte erreicht, gewinnt!!!");
        System.out.println("Punkte können gesammelt werden, indem man sich in alle Himmelsrichtungen (N,O,S,W) bewegt.");
        System.out.println("Ausnahmen sind: Spieler schwarz darf sich diagonal nach S-W bewegen und Spieler weiß darf sich diagonal nach N-O bewegen.");
        System.out.println("Das Spiel beginnt");

        Spieler aktuellerSpieler = spiel.getPitt().getSpielerW();

        do {
            //Spielbrett anzeigen
            for (int i = 0; i < 8; i++) {
                String zeile = "";
                for (int k = 0; k < 8; k++) {
                    zeile = zeile + spiel.getPitt().toStringAsArray()[i][k] + " ";
                }
                System.out.println(zeile);
            }

            //Score anzeigen
            System.out.println("\rDer aktuelle Score ist:");
            System.out.println(spiel.getPitt().getSpielerW().getFarbe().toString() + ":  " + spiel.getPitt().getSpielerW().getPunkte() + "Punkte");
            System.out.println(spiel.getPitt().getSpielerB().getFarbe().toString() + ":  " + spiel.getPitt().getSpielerB().getPunkte() + "Punkte");

            //aktueller Spieler anzeigen + input erfragen + input checken und ggfs neu fragen + bewegen (intern) + Punkte hochzählen
            spiel.inputVomSpieler(aktuellerSpieler);

            if (aktuellerSpieler.getFarbe() == Farbe.W)
                aktuellerSpieler = spiel.getPitt().getSpielerB();
            else if (aktuellerSpieler.getFarbe() == Farbe.B)
                aktuellerSpieler = spiel.getPitt().getSpielerW();

        } while (!aktuellerSpieler.hatGewonnen());

        System.out.println("Glückwunsch! " + aktuellerSpieler.getFarbe().toString() + " hat gewonnen!");

    }
}
