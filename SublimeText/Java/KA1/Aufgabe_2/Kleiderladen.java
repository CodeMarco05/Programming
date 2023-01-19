package KA1.Aufgabe_2;

import java.util.Random;

public class Kleiderladen {
    public static void main(String[] args) {
        
        Random random = new Random();
        
        Jeans [] regalJeans = new Jeans[20];
        Jacke [] regalJacken = new Jacke[20];
        Schuh [] regalSchuhe = new Schuh[20];

        String [] farben = {"gruen", "blau", "rot", "gelb", "pink"};
        String [] marken = {"adidas", "nike", "s.oliver", "off-white"};
        String [] arten = {"Stiefel", "Sportschuh", "Winterschuhe", "FlipFlops", "Sandalen"};
        String [] sohlen = {"glatt", "rau"};

        for (int i = 0; i < regalJeans.length; i++) {
            regalJeans[i] = new Jeans(i + 10, "blau", random.nextBoolean());
            regalJacken[i] = new Jacke(random.nextInt(49)+1, i + 15, farben[random.nextInt(farben.length)]);
            regalSchuhe[i] = new Schuh(marken[random.nextInt(marken.length)], arten[random.nextInt(arten.length)], sohlen[random.nextInt(sohlen.length)], i + 20);
        }
    }
}
