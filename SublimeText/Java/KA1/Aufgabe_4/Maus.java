package KA1.Aufgabe_4;

public class Maus {
    private int gewicht;
    private String farbe;
    
    public Maus(int gewicht, String farbe) {
        this.gewicht = gewicht;
        this.farbe = farbe;
    }

    public int getGewicht() {
        return gewicht;
    }
    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }
    public String getFarbe() {
        return farbe;
    }
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public static void fuettern(int gewicht){
        gewicht++;
        System.out.println("Neues Gewicht fuer Maus: " +  gewicht);
    }

}
