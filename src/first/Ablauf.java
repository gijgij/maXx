package first;

/**
 * @author Izabela Almeida, Giovanna Janeiro, Julia Keck, Ann-Katrin Schließus
 * */
public class Ablauf {
    private static Spiel spiel;

    public Ablauf() {
        this.spiel = new Spiel();
    }

    public static void main(String[] args) {

        //Spielbeginn Dialog
        system.out.println("Das Spiel beginnt");

        Spieler aktuellerSpieler = spiel.getPitt().getSpielerW();

        do {
            //spielbrett anzeigen
            for (int i = 0; i < 8; i++) {
                String zeile = "";
                for (int k = 0; k < 8; k++) {
                    zeile = zeile + spiel.getPitt().toStringAsArray()[i][k] + " ";
                }
                System.out.println(zeile);
            }

            //score anzeigen
            System.out.println("\rDer Aktuelle Score ist:");
            System.out.println(spiel.getPitt().getSpielerW().getFarbe().toString() + ":  " + spiel.getPitt().getSpielerW().getPunkte() + "Punkte");
            System.out.println(spiel.getPitt().getSpielerB().getFarbe().toString() + ":  " + spiel.getPitt().getSpielerB().getPunkte() + "Punkte");

            //akuteller spieler anzeigen + input erfragen + input checken und ggfs neu fragen + bewegen (intern) + Punkte hochzählen
            spiel.inputVomSpieler(aktuellerSpieler);

            if (aktuellerSpieler.getFarbe() == Farbe.W)
                aktuellerSpieler = spiel.getPitt().getSpielerB();
            else if (aktuellerSpieler.getFarbe() == Farbe.B)
                aktuellerSpieler = spiel.getPitt().getSpielerW();

        } while (aktuellerSpieler.hatGewonnen());

        System.out.println("Glückwunsch! " + aktuellerSpieler.getFarbe().toString() + " hat gewonnen.");

    }
}
