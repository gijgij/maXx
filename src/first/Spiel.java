package first;

public class Spiel {

    private Brett pit;

    public Spiel() {
        this.pit = new Brett();
    }

    public void inputVomSpieler(Spieler aktuellerSpieler){
        //TODO spielern Richtungen erklären
        String input = MyIO.promptAndRead(aktuellerSpieler.getFarbe().toString() + " ist dran.\rGeben Sie eine Richtung ein, um den Spieler zu bewegen:");

        boolean tryagain = true;

        do {
            switch (input) {
                case "N":
                    if (checkNeuePosition(aktuellerSpieler, new int[]{aktuellerSpieler.getPosition()[0] - 1, aktuellerSpieler.getPosition()[1]})) {
                        //TODO bewegen
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein:");
                    break;
                case "S":
                    if (checkNeuePosition(aktuellerSpieler, new int[]{aktuellerSpieler.getPosition()[0] + 1, aktuellerSpieler.getPosition()[1]})) {
                        //TODO bewegen
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein:");
                    break;
                case "W":
                    if (checkNeuePosition(aktuellerSpieler, new int[]{aktuellerSpieler.getPosition()[0], aktuellerSpieler.getPosition()[1] - 1})) {
                        //TODO bewegen
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein:");
                    break;
                case "O":
                    if (checkNeuePosition(aktuellerSpieler, new int[]{aktuellerSpieler.getPosition()[0], aktuellerSpieler.getPosition()[1] + 1})) {
                        //TODO bewegen
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein:");
                    break;
                case "NO":
                    // Weiß
                    if (aktuellerSpieler.getFarbe() == Farbe.W && checkNeuePosition(aktuellerSpieler, new int[]{aktuellerSpieler.getPosition()[0] - 1, aktuellerSpieler.getPosition()[1] + 1})){
                        //TODO bewegen
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein:");
                    break;
                case "SW":
                    // Schwarz
                    if (aktuellerSpieler.getFarbe() == Farbe.B && checkNeuePosition(aktuellerSpieler, new int[]{aktuellerSpieler.getPosition()[0] + 1, aktuellerSpieler.getPosition()[1] - 1})){
                        //TODO bewegen
                        tryagain = false;
                        break;
                    } else
                        System.out.println("Bitte geben sie eine andere Richtung ein:");
                    break;
            }
        }while(tryagain);
    }

    public boolean checkNeuePosition(Spieler aktuellerSpieler, int[] neuePosition){
        //TODO implement
        return false; //TODO return statement
    }
    public void bewegen(Spieler aktuellerSpieler, int[] neuePosition){
        //TODO implement
        // - Felder wo hinbewegt wird, muss verändert werden
        // - Position figur muss verändert werden
        // - Punke müssen hochgezählt werden (und berechnen)
    }

    public Brett getPit() {
        return pit;
    }
}
