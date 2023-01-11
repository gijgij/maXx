package first;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Izabela Almeida, Giovanna Janeiro, Julia Keck, Ann-Katrin Schließus
 * @version 2.0, 11.01.23
 *
 * */
public class Field {
    private Feldtyp feldtyp;
    private int[] inhalt = new int[2];

    public Field(Feldtyp feldtyp) {
        this.feldtyp = feldtyp;
        if (feldtyp == Feldtyp.FRACTION)
            inhalt = new int[]{ThreadLocalRandom.current().nextInt(10, 999), ThreadLocalRandom.current().nextInt(10, 999)};
        else if (feldtyp == Feldtyp.ZERO)
            inhalt = new int[]{0,1};
    }

    public int[] getInhalt() {
        return inhalt;
    }

    @Override
    public String toString() {
        if (feldtyp == Feldtyp.ZERO)
            return "0";
        return inhalt[0] + "/" + inhalt[1];
    }
}
