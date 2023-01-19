package KA1.Aufgabe_2;

public class Jacke {
    private int groesse;
    private int preis;
    private String farbe;

    public Jacke(int groesse, int preis, String farbe){
        this.groesse = groesse;
        this.preis = preis;
        this.farbe = farbe;
    }

    public void preisErhoehung(){
        preis *= 1.10;
    }

    public void setPreis(int preis){
        this.preis = preis;
    }

    public int getGroesse(){
        return groesse;
    }

    public int getPreis(){
        return preis;
    }

    public String getFarbe(){
        return farbe;
    }

}
