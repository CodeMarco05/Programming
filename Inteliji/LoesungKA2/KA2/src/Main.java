import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Zylinder zylinder = null;

        while(true){
            System.out.println("Welche Werte des Zylinders sind bekannt?");
            System.out.println("Wähle zwischen\n  (1) Radius\n  (2) Umfang oder \n  (3) Höhe und Volumen\n  (4) Programm beenden");
            System.out.print("Deine Wahl: ");


            testi{
                int wahl = scanner.nextInt();

                if(wahl == 1){
                    System.out.print("Gib den Radius des Zylinders in m ein: ");
                    zylinder = new Zylinder();
                    zylinder.setRadius(scanner.nextDouble());

                    System.out.println("Die Höhe des Zylinders ist " + zylinder.getaHoehe() + " m lang.");
                    System.out.println("Das Volumen des Zylinders ist: " + zylinder.berechneVolumen() + " Kubikmeter.");
                } else if (wahl == 2) {
                    System.out.print("Gib den Umfang des Zylinders in m ein: ");
                    zylinder = new Zylinder(scanner.nextDouble());

                    System.out.println("Der Radius des Zylinders ist " + zylinder.getRadius() + " m lang.");
                    System.out.println("Die Höhe des Zylinders ist " + zylinder.getaHoehe() + " m lang.");
                    System.out.println("Das Volumen des Zylinders ist: " + zylinder.berechneVolumen() + " Kubikmeter.");
                } else if (wahl == 3) {
                    System.out.println("Gib die Höhre des Zylinders in m ein: ");
                    double h = scanner.nextDouble();
                    System.out.println("Gib das Volumen des Zylinders in m ein: ");
                    double v = scanner.nextDouble();
                    zylinder = new Zylinder(v, h);

                    System.out.println("Der Radius des Zylinders ist " + zylinder.getRadius() + " m lang. ");

                } else if (wahl == 4) {
                    break;
                }else{
                    System.out.println("Ungültige Eingabe!");
                }
            }catch (Exception e){
                scanner.next();
                System.out.println("Ungültige Eingabe!");
            }

            System.out.println();
        }
        System.out.println("Programm beendet!");

    }

}