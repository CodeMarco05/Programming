package KA1.Aufgabe_2;

public class Jeans {
    private double kosten;
    private String faerbung;
    private boolean knopf;

    public Jeans(double kosten, String faerbung, boolean knopf){
        this.kosten = kosten;
        this.faerbung = faerbung;
        this.knopf = knopf;
    }

    public void preisErhoehung(){
        kosten *= 1.15;
    }

    public double getKosten() {
        return kosten;
    }

    public void setKosten(double kosten) {
        this.kosten = kosten;
    }

    public String getFaerbung() {
        return faerbung;
    }

    public void setFaerbung(String faerbung) {
        this.faerbung = faerbung;
    }

    
    public void setKnopf(boolean knopf){
        this.knopf = knopf;
    }

    public boolean isKnopf(){
        return knopf;
    }
}
