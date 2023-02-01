import java.util.Scanner;

public class A_2_4_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Amount: "); double amount = scanner.nextDouble();
        scanner.close();

        if(amount > 1000){
            System.out.println("Eingabe ist schon in Litern.");
        }else if(amount > 1.0){
            System.out.println("Ausgabe in Liter, ca. " + amount + " l.");
        }else if(amount > 0.1){
            System.out.println("Ausgabe in Zentiliter, ca. " + amount*100 + " cl.");
        }else if (amount > 0.001){
            System.out.println("Ausgabe in Milliliter, ca. " + amount*1000 + " ml.");
        }else if(amount <= 0.001){
            System.out.println("Der Wert ist zu klein!");
        }
    }
}
