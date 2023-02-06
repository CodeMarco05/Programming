public class A_2_5_8{
      public static void main(String[] args) {
            int num = 2539;
            String s = num+"";
            char array[] = s.toCharArray();
            
            int largest = 0;
            int lowest = 9;

            for(int i = 0; i < array.length; i++){
                  try {
                        int temp = Integer.parseInt(array[i]+"");
                        largest = Math.max(largest, temp);
                        lowest = Math.min(lowest, temp);
                  } catch (Exception e) {
                        
                  }
            }

            System.out.println("Largest " + largest);
            System.out.println("Lowest " + lowest);
           
      }
}