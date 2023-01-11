package first;

public enum Farbe {
    W(new int[]{2,3}),
    B(new int[]{5,4});

    private final int[] startposition;

    Farbe(int[] startposition) {
        this.startposition = startposition;
    }

    public int[] getStartposition() {
        return startposition;
    }
}
