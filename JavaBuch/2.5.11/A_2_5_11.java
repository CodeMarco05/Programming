import java.util.Scanner;

public class A_2_5_11 {
      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Checkerboard with: "); int width = scanner.nextInt();
            System.out.print("Checkerboard height: "); int height = scanner.nextInt();

            boolean output = true;
            for(int i = 0; i < height; i++){
                  for(int j = 0; j < width; j++){
                        if(output){
                              System.out.print("_");
                        }else{
                              System.out.print("#");
                        }
                        output = !output;
                  }
                  if(width % 2 == 0){
                        output = !output;
                  }
                  System.out.println();
            }
            scanner.close();
      }
}
