package first;

public class Spieler {

    private int[] position = new int[2];
    private final Farbe farbe;
    private int Punkte;

    public Spieler( Farbe farbe) {
        this.position = farbe.getStartposition();
        this.farbe = farbe;
        this.Punkte=0;
    }

    public void setPosition(int x, int y){
        position[0]=x;
        position[1]=y;
    }

    public int[] getPosition() {
        return position;
    }

    public Farbe getFarbe() {
        return farbe;
    }

    public int getPunkte() {
        return Punkte;
    }

    public void addPunkte(int punkte) {
        Punkte=+punkte;
    }
}
