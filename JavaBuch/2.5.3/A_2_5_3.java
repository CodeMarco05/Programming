import java.util.Scanner;

public class A_2_5_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int input = 0;

        do {
            System.out.print("Number: "); input = scanner.nextInt();
            sum += input;
        } while (input != 0);

        System.out.println("Total: " + sum);
        scanner.close();
    }
}
