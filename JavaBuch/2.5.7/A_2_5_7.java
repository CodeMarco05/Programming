import java.util.Scanner;

public class A_2_5_7 {
      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a number: "); long num = scanner.nextLong();
            scanner.close();

            boolean state = true;
            int runs = 1;
            long save = num;
            for(int i = 1; i <= num/2; i++){
                  if(num % i == 0){
                        num /= i;
                        runs++;
                  }else{
                        state = false;
                        break;
                  }
                  
            }


            if(state){
                  System.out.print(save + " = " + runs + "!");
            }else{
                  System.out.print("Is not a factorial");
            }
            
            scanner.close();
      }
}
