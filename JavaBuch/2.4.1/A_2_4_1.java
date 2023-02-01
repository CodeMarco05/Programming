import java.util.Scanner;

public class A_2_4_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double lower = 0.1;
        final double upper = 0.2;

        System.out.print("Money: "); double money = scanner.nextDouble();

        if(money > 1000.0 - 1000.0*lower && money < 1000.0 + 1000.0*upper){
            System.out.println("Good boy!");
        }else{
            System.out.println("Yout son of a bi***!");
        }
        scanner.close();
    }
}
