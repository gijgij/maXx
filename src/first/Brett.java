package first;

/**
 * @author Izabela Almeida, Giovanna Janeiro, Julia Keck, Ann-Katrin Schließus
 * */
public class Brett {
    private Field[][] brett = new Field[8][8];

    private Spieler spielerB;
    private Spieler spielerW;

    public Brett() {
        this.spielerB = new Spieler(Farbe.B);
        this.spielerW = new Spieler(Farbe.W);
        resetBrett();
    }

    public void resetBrett() {

        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                brett[i][k] = new Field(Feldtyp.FRACTION);
            }
        }
        brett[2][3] = new Field(Feldtyp.ZERO);
        brett[5][4] = new Field(Feldtyp.ZERO);
        spielerW.setPosition(2, 3);
        spielerB.setPosition(5, 4);
    }

    public Spieler getSpielerB() {
        return spielerB;
    }

    public Spieler getSpielerW() {
        return spielerW;
    }

    public String[][] toStringAsArray() {
        String[][] brettString = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                brettString[i][k] = brett[i][k].toString();
            }
        }
        brettString[spielerB.getPosition()[0]][spielerB.getPosition()[1]] = spielerB.getFarbe().toString();
        brettString[spielerW.getPosition()[0]][spielerW.getPosition()[1]] = spielerW.getFarbe().toString();
        return brettString;
    }

    public void setFeld(int x, int y, Field wert){
        brett[x][y] = wert;
    }

    public Field getFeld(int x, int y){
        return brett[x][y];
    }
}

