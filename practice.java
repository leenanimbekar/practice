import java.util.Scanner;

/**
 * Created by nimbekl on 10/13/16.
 */
public class practice{
    public static void main(String args[]){
       Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        for(int i = number ;i<Math.pow(10,i);i++) {
            String x = i % 10 + "" + i / 10;
            int newNumber = Integer.valueOf(x);
            if (newNumber == (i % 10) * i) {
                System.out.println(i);
            }
        }
    }
}
