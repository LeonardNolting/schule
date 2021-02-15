public class Feld {
    int[] feld;

    public int[] getFeld() {
        return feld;
    }

    public Feld(int laenge) {
        feld = new int[laenge];
    }

    void befuellen() {
        for (int i = 0; i < feld.length; i++)
            feld[i] = i + 1;
    }

    void ausgeben() {
        for (int element : feld)
            System.out.print(element + " ");
        System.out.println();
    }
}
