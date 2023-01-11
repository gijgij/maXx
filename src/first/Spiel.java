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

        boolean tryagain = true;
        int[] neuePosition;

        do {
            String input = MyIO.promptAndRead(aktuellerSpieler.getFarbe().toString() + " ist dran. Geben Sie eine Richtung ein, um den Spieler zu bewegen:");

            switch (input) {
                case "N":
                    neuePosition = new int[]{aktuellerSpieler.getPosition()[0] - 1, aktuellerSpieler.getPosition()[1]};
                    if (checkNeuePosition(neuePosition)) {

                        bewegen(aktuellerSpieler,neuePosition);
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein.");
                    break;
                case "S":
                    neuePosition=new int[]{aktuellerSpieler.getPosition()[0] + 1, aktuellerSpieler.getPosition()[1]};
                    if (checkNeuePosition( neuePosition )) {

                        bewegen(aktuellerSpieler,neuePosition);
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein.");
                    break;
                case "W":
                    neuePosition =new int[]{aktuellerSpieler.getPosition()[0], aktuellerSpieler.getPosition()[1] - 1};
                    if (checkNeuePosition(neuePosition)) {

                        bewegen(aktuellerSpieler,neuePosition);
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein.");
                    break;
                case "O":
                    neuePosition = new int[]{aktuellerSpieler.getPosition()[0], aktuellerSpieler.getPosition()[1] + 1};
                    if (checkNeuePosition(neuePosition)) {


                        bewegen(aktuellerSpieler,neuePosition);
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein.");
                    break;
                case "NO":
                    // Weiß
                    neuePosition=new int[]{aktuellerSpieler.getPosition()[0] - 1, aktuellerSpieler.getPosition()[1] + 1};
                    if (aktuellerSpieler.getFarbe() == Farbe.W && checkNeuePosition(neuePosition)) {

                        bewegen(aktuellerSpieler,neuePosition);
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein.");
                    break;
                case "SW":
                    // Schwarz
                    neuePosition=new int[]{aktuellerSpieler.getPosition()[0] + 1, aktuellerSpieler.getPosition()[1] - 1};
                    if (aktuellerSpieler.getFarbe() == Farbe.B && checkNeuePosition(neuePosition)) {

                        bewegen(aktuellerSpieler,neuePosition);
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein.");
                    break;
            }
        } while (tryagain);
    }

    public boolean checkNeuePosition(int[] neuePosition) {
        boolean result = neuePosition[0]>=0 && neuePosition[0]<=7;
        result = result &&  neuePosition[1]>=0 && neuePosition[1]<=7;
        result = result && (neuePosition[0] != pitt.getSpielerB().getPosition()[0] || neuePosition[1] != pitt.getSpielerB().getPosition()[1]);
        result = result && (neuePosition[0] != pitt.getSpielerW().getPosition()[0] || neuePosition[1] != pitt.getSpielerW().getPosition()[1]);
        return result;
    }

    public void bewegen(Spieler aktuellerSpieler, int[] neuePosition) {
        aktuellerSpieler.setPosition(neuePosition[0],neuePosition[1]);

        Field aktuellesFeld = pitt.getFeld(neuePosition[0],neuePosition[1]);

        aktuellerSpieler.addPunkte(aktuellesFeld.getInhalt()[0] / aktuellesFeld.getInhalt()[1]); //TODO passt des?

        pitt.setFeld(neuePosition[0],neuePosition[1],new Field(Feldtyp.ZERO));
    }

    public Brett getPitt() {
        return pitt;
    }
}
