package first;

public class Brett {
    private Feld [][] brett = new Feld[8][8];

    Spieler spielerB = new Spieler(Farbe.B);
    Spieler spielerW = new Spieler(Farbe.W);

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






}

