import java.util.Scanner;

public class A_2_4_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strings [] = {"Ay", "Ay, ay", "Ein Ei", "yes", "ja"};
        boolean valid = false;

        System.out.print("Input: "); String input = scanner.nextLine();

        for (String string : strings) {
            if(string.equals(input)){
                valid = true;
            }
        }

        if(valid){
            System.out.println("Keep it up!");
        }else{
            System.out.println("Don't you dare!");
        }
        scanner.close();
    }
}
