package first;

public class Brett {
    private Feld [][] brett = new Feld[8][8];

    private Spieler spielerB;
    private Spieler spielerW;

    public Brett() {
        this.spielerB = new Spieler(Farbe.B);
        this.spielerW = new Spieler(Farbe.W);
        resetBrett();
    }

    public void resetBrett(){
        for (Feld[] n : brett){
            for (Feld m: n){
                m=Feld.FRACTION;
            }
        }
        brett[2][3]=Feld.ZERO; //TODO use Startposition
        brett[5][4]=Feld.ZERO; //TODO use Startposition
        //TODO reset spieler
    }

    public Spieler getSpielerB() {
        return spielerB;
    }

    public Spieler getSpielerW() {
        return spielerW;
    }
}

