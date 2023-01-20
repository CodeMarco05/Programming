package KA1.Aufgabe_3;

import java.util.Random;
import java.util.Scanner;



public class Menue {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        Random random = new Random();
        
        
        int num;

        String [][] auswahlB = {
            {"Big Roesti", "6.89"}, 
            {"Grand BBQ Cheese", "3.56"}, 
            {"McCrispy Homestyle", "4.56"}, 
            {"Big Tasty Bacon", "2.78"}, 
            {"Big Mac", "9.78"}, 
            {"Hamburger Royal TS","10.67"}, 
            {"Hamburger Royal Käse", "8.23"}, 
            {"McChicken Classic", "5.34"}   
        };

        String [][] auswahlG = {
            {"Cola", "2.29"}, 
            {"Fanta", "3.15"}, 
            {"Sprite", "1.15"}, 
            {"Wasser", "2.00"}, 
            {"Eistee", "5.00"}, 
            {"Mezzo Mix","2.50"}, 
            {"Blubbwasser", "2.39"}, 
            {"Apfelschorle", "1.78"}   
        };

        System.out.println("Bitte waehlen Sie Ihr Burger: ");
        for(int i = 0; i < auswahlB.length; i++){
            System.out.println("[" + i + "] " + auswahlB[i][0]);
        }
        System.out.println(); 
        int kundenAuswahlB = scanner.nextInt();
        Burger b1 = new Burger(auswahlB[kundenAuswahlB][0], Double.parseDouble(auswahlB[kundenAuswahlB][1]));
        
        System.out.println("Bitte waehlen Sie Ihr Getraenk: ");
        for(int i = 0; i < auswahlG.length; i++){
            System.out.println("[" + i + "] " + auswahlG[i][0]);
        }
        System.out.println();
        int kundenAuswahlG = scanner.nextInt();
        Getreank g1 = new Getreank(auswahlG[kundenAuswahlG][0], Double.parseDouble(auswahlG[kundenAuswahlG][1]));

        System.out.println();
        System.out.println("Ihr Menue besteht aus: " + b1.getTyp() + " und " + g1.getMarke());
        num = scanner.nextInt();

        
        
    }

    
}
