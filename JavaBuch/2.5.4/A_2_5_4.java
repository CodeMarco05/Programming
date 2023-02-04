public class A_2_5_4{
    public static void main(String[] args) {
        double t = Math.random()*10;
        do {
            if(t < 1){
                t *= 2;
            }else{
                t--;
            }
            System.out.println(t);
        } while (t > 0);
    }
}