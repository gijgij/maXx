package first;

/**
 * @author Izabela Almeida, Giovanna Janeiro, Julia Keck, Ann-Katrin Schließus
 * */

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public enum Feld {
    ZERO("NOT FRACTION"),
    FRACTION("FRACTION");

    private int[] inhalt = new int[]{0, 1};

    @Override
    public String toString() {
        if (this == ZERO) return "0";
        return inhalt[0] + "/" + inhalt[1];
    }

    Feld(String fraction) {
        if (fraction == "FRACTION") {
            inhalt = new int[]{ThreadLocalRandom.current().nextInt(10, 999), ThreadLocalRandom.current().nextInt(1, 999)};
        }


    }

}
