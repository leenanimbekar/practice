/**
 * Created by nimbekl on 11/2/17.
 */
import java.util.*;
public class fibbo {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        for(int i = 1;i<=num;i++) {
            System.out.println(fibbo(i));
        }
    }
    static int fibbo(int num){
        if(num == 0 || num == 1){
            return num;
        }else {
            return fibbo(num-1)+fibbo(num-2);
        }
    }
}
