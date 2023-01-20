package KA1.Aufgabe_4;

public class Giraffe {
    private int gewicht;
    private int groesse;
    
    public Giraffe(int gewicht, int groesse) {
        this.gewicht = gewicht;
        this.groesse = groesse;
    }

    public int getGewicht() {
        return gewicht;
    }
    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }
    public int getGroesse() {
        return groesse;
    }
    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

    public static void fuettern(int gewicht){
        gewicht++;
        System.out.println("Neues Gewicht fuer Giraffe: " + gewicht);
    }


}
