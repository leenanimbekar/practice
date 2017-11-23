/**
 * Created by nimbekl on 4/4/17.
 */
import java.util.*;
public class countCommonFactors {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int a,b,min,count=0;
        a  = in.nextInt();
        b = in.nextInt();
        min = a<b?a:b;
        if(min == 1){
            count = 1;
        }
        for (int i=1;i<=min/2;i++){
            if(a%i == 0 && b%i == 0){
               count++;
            }
        }
        if (a%min == 0 && b%min == 0) {
            count++;
        }
        System.out.println(count);
    }
}
