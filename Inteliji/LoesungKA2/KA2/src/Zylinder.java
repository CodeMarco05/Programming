import java.util.Random;

public class Zylinder {

    private double aRadius;
    private double aHoehe;

    public Zylinder(){
    }
    public Zylinder(double pUmfang){
        aRadius = pUmfang / (2*Math.PI);
        bestimmeHoehe();
    }
    public Zylinder(double pVolumen, double pHoehe){
        aHoehe = pHoehe;
        aRadius = Math.sqrt(pVolumen/(pHoehe*Math.PI));
    }

    public double getRadius() {
        return aRadius;
    }

    public void setRadius(double aRadius) {
        this.aRadius = aRadius;
        bestimmeHoehe();
    }

    public double getaHoehe() {
        return aHoehe;
    }

    public void bestimmeHoehe(){
        Random random = new Random();
        aHoehe = random.nextDouble()*((aRadius*2)-0.00000000001);
    }

    public double berechneVolumen(){
        return (Math.PI*aRadius*aRadius*aHoehe);
    }
}
