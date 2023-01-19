package KA1.Aufgabe_2;

public class Schuh {
    private String marke;
    private String art;
    private String sohle;
    private int preis;

    public Schuh(String marke, String art, String sohle, int preis){
        this.marke = marke;
        this.art = art;
        this.sohle = sohle;
        this.preis = preis;
    }

    public void preisErhoehung(){
        preis *= 1.10;
    }

    public void setSohle(String sohle){
        this.sohle = sohle;
    }

    public void setSohle(int preis){
        this.preis = preis;
    }

    public String getMarke(){
        return marke;
    }

    public String getArt(){
        return art;
    }

    public String getSohle(){
        return sohle;
    }

    public int getPreis(){
        return preis;
    }
}
