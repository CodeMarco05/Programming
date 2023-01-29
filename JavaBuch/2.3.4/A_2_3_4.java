import java.util.Scanner;

public class A_2_3_4 {
      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter the amount of money: ");
            double money = scanner.nextDouble();
            
            double rest = 0;

            int twoEuro = (int) money / 2;
            rest = money % 2;

            int oneEuro = (int) rest / 1;
            rest = rest % 1;

            int fiftyCent = (int) (rest / 0.5);
            rest = rest % 0.5;

            int twentyCent = (int) (rest / 0.2);
            rest = rest % 0.2;

            int tenCent = (int) (rest / 0.1);
            rest = rest % 0.1;

            int fiveCent = (int) (rest / 0.05);
            rest = rest % 0.05;

            int twoCent = (int) (rest / 0.02);
            rest = rest % 0.02;

            int oneCent = (int) (rest / 0.01);


            System.out.println(twoEuro + " x  2 Euro");
            System.out.println(oneEuro + " x  1 Euro");
            System.out.println(fiftyCent + " x  50 Cent");
            System.out.println(twentyCent + " x  20 Cent");
            System.out.println(tenCent + " x  10 Cent");
            System.out.println(fiveCent + " x  5 Cent");
            System.out.println(twoCent + " x  2 Cent");
            System.out.println(oneCent + " x  1 Cent");
            scanner.close();
      }
}
