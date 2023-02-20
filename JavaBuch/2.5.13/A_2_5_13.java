public class A_2_5_13{
      public static void main(String[] args) {
          String toRigth = "><>";
          String toLeft = "<><";
  
          int repetitions = 10;
  
          for(int i = 1; i <= repetitions; i++){
              for(int j = 1; j <= repetitions; j++){
                  System.out.print(toRigth + "  ");
              }
              for(int j = 1; j <= repetitions; j++){
                  System.out.print(toLeft + "  ");
              }
              System.out.println();
          }
      }
  }