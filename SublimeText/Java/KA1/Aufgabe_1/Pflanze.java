

public class Pflanze{
	
	private String farbe;
	private String art;
	private int preis;

	

	public Pflanze(String farbe, int preis){
		this.farbe = farbe;
		this.preis = preis;
	}

	public void setFarbe(String farbe){
		this.farbe = farbe;
	}

	public void setPreis(int preis){
		this.preis = preis;
	}

	public String getArt(){
		return art;
	}

	public String getFarbe(){
		return farbe;
	}

	public int getPreis(){
		return preis;
	}



}