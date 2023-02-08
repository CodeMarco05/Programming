import java.util.Random;

public class A_2_5_12{
    public static void main(String[] args) {
        Random random = new Random();
        int width = 10;

        for(int i = 0; i < width/2; i++){
            for(int j = width/2-1; j > i; j--){
                System.out.print(" ");
            }
            aussen: for(int j = 0; j <= i*2; j++){
                if(j != 0 && j!= i*2){
                    int rand = random.nextInt(0, 11);
                    if(rand < 3){
                        System.out.print("o");
                        continue aussen;
                    }
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}