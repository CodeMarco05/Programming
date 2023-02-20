import java.util.ArrayList;

public class A_2_5_14 {
      public static void main(String[] args) {
            
            int [] xList = new int[100];
            int [] lList = new int[100];
            int [] tList = new int[100];
            int [] oList = new int[100];

            for(int index = 0; index < 1;){
                  for(int x = 0; x <= 5; x++){
                        for(int l = 0; l <= 5; l++){
                              xList[index] = x;
                              lList[index] = l;
                              tList[index] = x+l;
                              oList[index] = l-x;
                              index++;
                        }
                        
      
                  }
            }
            
            for (int i = 0; i < oList.length; i++) {
                  System.out.println("x: " + xList[i]);
                  System.out.println("l: " + lList[i]);
                  System.out.println("t: " + tList[i]);
                  System.out.println("o: " + oList[i]);
                  System.out.println();
            }
      }
}
