package first;
import java.util.concurrent.ThreadLocalRandom;

public enum Feld {
    ZERO(),
    FRACTION("FRACTION");

    private int[] inhalt = new int[]{0, 1};
    Feld(String fraction){
        if (fraction == "FRACTION"){
            inhalt= new int[]{ThreadLocalRandom.current().nextInt(1 , 999), ThreadLocalRandom.current().nextInt(1 , 999)};
        }
    }

}
