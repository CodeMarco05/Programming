package KA1.Aufgabe_4;

import java.util.Scanner;

public class Zoo {
    static Maus [] gehegeMaus = new Maus[5];
    static Tiger [] gehegeTiger = new Tiger[5];
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int num;

        
        Giraffe g1 = new Giraffe(300, 6);

        for(int i = 0; i < gehegeTiger.length; i++){
            gehegeTiger[i] = new Tiger(200, true);
            gehegeMaus[i] = new Maus(2, "grau");
        }

        while(true){
            System.out.println("Zoo öffnen (0) oder Tiere füttern (1)");
            num = scanner.nextInt();
            if(num == 0){
                g1 = zooOeffnet(g1);
            }else{
              
            }
        }

        

    }

    public static Giraffe zooOeffnet(Giraffe g1){
        for(int i = 0; i < gehegeMaus.length; i++){
            gehegeMaus[i].setGewicht(gehegeMaus[i].getGewicht()-1);
            gehegeTiger[i].setGewicht(gehegeTiger[i].getGewicht()-1);   
        }
        g1.setGewicht(g1.getGewicht()-1);
        return g1;
    }

}
