package KA1.Aufgabe_3;

public class Burger {
    private String typ;
    private double preis;

    public Burger(String typ, double preis){
        this.typ = typ;
        this.preis = preis;
    }

    public String getTyp(){
        return typ;
    }

    public double getPreis(){
        return preis;
    }

}
