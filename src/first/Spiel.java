package first;

/**
 * @author Izabela Almeida, Giovanna Janeiro, Julia Keck, Ann-Katrin Schließus
 * */

public class Spiel {

    private Brett pitt;

    public Spiel() {
        this.pitt = new Brett();
    }

    public void inputVomSpieler(Spieler aktuellerSpieler) {
        //TODO spielern Richtungen erklären
        String input = MyIO.promptAndRead(aktuellerSpieler.getFarbe().toString() + " ist dran.\rGeben Sie eine Richtung ein, um den Spieler zu bewegen:");

        boolean tryagain = true;
        int[] neuePosition;

        do {
            switch (input) {
                case "N":
                    neuePosition = new int[]{aktuellerSpieler.getPosition()[0] - 1, aktuellerSpieler.getPosition()[1]};
                    if (checkNeuePosition(neuePosition)) {

                        bewegen(aktuellerSpieler,neuePosition);
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein:");
                    break;
                case "S":
                    neuePosition=new int[]{aktuellerSpieler.getPosition()[0] + 1, aktuellerSpieler.getPosition()[1]};
                    if (checkNeuePosition( neuePosition )) {

                        bewegen(aktuellerSpieler,neuePosition);
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein:");
                    break;
                case "W":
                    neuePosition =new int[]{aktuellerSpieler.getPosition()[0], aktuellerSpieler.getPosition()[1] - 1};
                    if (checkNeuePosition(neuePosition)) {

                        bewegen(aktuellerSpieler,neuePosition);
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein:");
                    break;
                case "O":
                    neuePosition = new int[]{aktuellerSpieler.getPosition()[0], aktuellerSpieler.getPosition()[1] + 1};
                    if (checkNeuePosition(neuePosition)) {


                        bewegen(aktuellerSpieler,neuePosition);
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein:");
                    break;
                case "NO":
                    // Weiß
                    neuePosition=new int[]{aktuellerSpieler.getPosition()[0] - 1, aktuellerSpieler.getPosition()[1] + 1};
                    if (aktuellerSpieler.getFarbe() == Farbe.W && checkNeuePosition(neuePosition)) {

                        bewegen(aktuellerSpieler,neuePosition);
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein:");
                    break;
                case "SW":
                    // Schwarz
                    neuePosition=new int[]{aktuellerSpieler.getPosition()[0] + 1, aktuellerSpieler.getPosition()[1] - 1};
                    if (aktuellerSpieler.getFarbe() == Farbe.B && checkNeuePosition(neuePosition)) {

                        bewegen(aktuellerSpieler,neuePosition);
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein:");
                    break;
            }
        } while (tryagain);
    }

    public boolean checkNeuePosition(int[] neuePosition) {
        boolean result = false;
        result &= neuePosition[0]>=0 && neuePosition[0]<=7;
        result &= neuePosition[1]>=0 && neuePosition[1]<=7;
        result &= neuePosition[0] != pitt.getSpielerB().getPosition()[0] && neuePosition[1] != pitt.getSpielerB().getPosition()[1];
        result &= neuePosition[0] != pitt.getSpielerW().getPosition()[0] && neuePosition[1] != pitt.getSpielerW().getPosition()[1];
        return result;
    }

    public void bewegen(Spieler aktuellerSpieler, int[] neuePosition) {
        aktuellerSpieler.setPosition(neuePosition[0],neuePosition[1]);
        //pitt[neuePosition[0]][neuePosition[1]] = Feld.ZERO;

        //TODO implement
        // - Felder wo hinbewegt wird, muss verändert werden
        // - Position figur muss verändert werden
        // - Punke müssen hochgezählt werden (und berechnen)
    }

    public Brett getPitt() {
        return pitt;
    }
}
