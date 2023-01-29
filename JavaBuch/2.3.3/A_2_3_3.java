import java.util.Scanner;

public class A_2_3_3 {
      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            boolean same = false;

            System.out.print("First number: "); int x = scanner.nextInt();
            System.out.print("Second number: "); int y = scanner.nextInt();

            int x1 = x % 10;
            int x2 = (x / 10) % 10;

            int y1 = y % 10;
            int y2 = (y / 10) % 10;

            if(x1 == y1 || x1 == y2 || x2 == y1 || x2 == y2){
                  same = true;
            }
            
            System.out.println("Same numbers: " + same);
            scanner.close();
      }
}
