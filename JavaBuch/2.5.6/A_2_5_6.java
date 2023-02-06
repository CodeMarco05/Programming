import java.util.Scanner;

public class A_2_5_6 {
      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            long sum = 1;
            System.out.print("Number: "); int num = scanner.nextInt();

            if(num > 0){
                  for(int i = 1; i <= num; i++){
                        sum = sum * i;
                  }
      
                  System.out.println("Ergebnis: " + sum);
                  
            }else{
                  System.out.println("Number must not be negative");
            }
            scanner.close();
      }
}
