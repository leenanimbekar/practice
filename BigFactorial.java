/**
 * Created by nimbekl on 11/5/17.
 */
import java.util.*;
import java.math.BigInteger;
public class BigFactorial {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        BigInteger f = new BigInteger("1");
        for(int i = 0;i<n;i++){
            f = f.multiply(BigInteger.valueOf(n-i));
        }
        System.out.println(f);
    }
}
