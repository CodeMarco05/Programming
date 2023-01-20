package KA1.Aufgabe_4;

public class Tiger {
    private int gewicht;
    private boolean bruellen;

    public Tiger(int gewicht, boolean bruellen) {
        this.gewicht = gewicht;
        this.bruellen = bruellen;
    }

    public int getGewicht() {
        return gewicht;
    }
    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }
    public boolean isBruellen() {
        return bruellen;
    }
    public void setBruellen(boolean bruellen) {
        this.bruellen = bruellen;
    }

    public static void fuettern(int gewicht){
        gewicht++;
        System.out.println("Neues Gewicht fuer Tiger: " + gewicht);
    }

}
