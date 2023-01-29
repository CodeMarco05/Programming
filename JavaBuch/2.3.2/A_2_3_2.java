


import java.util.Scanner;

public class A_2_3_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Number of bottles in total?");
        int bottles = scanner.nextInt();
        int captain = bottles / 2;
        System.out.println("Bottles for the captain: " + captain);

        int crewBottles = bottles - captain;
        System.out.println("Bottles for all crew members: " + crewBottles);

        System.out.println("How many crew members?");
        int crewMembers = scanner.nextInt();
        scanner.close();

        boolean even = crewBottles % crewMembers == 0 ? true: false;

        System.out.println("Faire share without remainder? " + even);
    }
}