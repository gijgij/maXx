package first;

/**
 * @author Izabela Almeida, Giovanna Janeiro, Julia Keck, Ann-Katrin Schließus
 * @version 2.0, 11.01.23
 *
 * */

public class Spieler {

    private int[] position = new int[2];
    private final Farbe farbe;
    private double Punkte;

    public Spieler(Farbe farbe) {
        this.position = farbe.getStartposition();
        this.farbe = farbe;
        resetPunkte();
    }

    public boolean hatGewonnen() {
        return Punkte > 53;
    }

    public void setPosition(int x, int y) {
        position[0] = x;
        position[1] = y;
    }

    public int[] getPosition() {
        return position;
    }

    public Farbe getFarbe() {
        return farbe;
    }

    public double getPunkte() {
        return Punkte;
    }

    public void addPunkte(double punkte) {
        Punkte = Punkte + punkte;
    }

    public void resetPunkte() {
        Punkte = 0;
    }
}
