import java.util.*;

/**
 * Created by nimbekl on 10/28/17.
 */
public class legos {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int totalTestCases = s.nextInt();
        int[] result = new int[totalTestCases];
        for(int i = 0; i<totalTestCases;i++){
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            int d = s.nextInt();
            int p = s.nextInt();
            int q = s.nextInt();
            result[i] = (a*b*c*d)/(p*q);
        }
        for(int i = 0; i<totalTestCases;i++){
            System.out.println(result[i]);
        }
    }
}