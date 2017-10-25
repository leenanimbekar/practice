import java.util.Scanner;
/**
 * Created by nimbekl on 6/10/17.
 */
public class recurssionProblem {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[n+1];
        for(int i = 1;i<=n;i++){
            arr[i] = in.nextInt();
        }
        for(int i = 0;i<q;i++){
            int l = in.nextInt();
            int r = in.nextInt();
            long[] lst =  new long[r+1];
            for(int j = 0 ;j+l<=r;j++){
                if((j+l)!= r){
                    lst[j] = (getFibbonaci(arr[l+j]));
                }
                else {
                    lst[r] = (getFibbonaci(arr[r]));
                };
            }
            getGCD(lst);
        }
    }

    private static long getFibbonaci(int n) {

        long a = 0;
        long b = 1;
        for (int i = 31 - Integer.numberOfLeadingZeros(n); i >= 0; i--) {
            long d = a * ((b<<1) - a);
            long e = (a*a) + (b*b);
            a = d;
            b = e;
            if (((n >>> i) & 1) != 0) {
                long c = a+b;
                a = b;
                b = c;
            }
        }
        return a;
    }
    public static long getGCD(long[] numbers){
        long result = numbers[0];
        for(int i = 1; i < numbers.length; i++)
        result = gcd(result, numbers[i]);
        System.out.println(result);
        return result;
    }

    public static long gcd(long p, long q) {
        if (q == 0) return p;
        if (p == 0) return q;

        if ((p & 1) == 0 && (q & 1) == 0) return gcd(p >> 1, q >> 1) << 1;

        else if ((p & 1) == 0) return gcd(p >> 1, q);

        else if ((q & 1) == 0) return gcd(p, q >> 1);

        else if (p >= q) return gcd((p-q) >> 1, q);

        else return gcd(p, (q-p) >> 1);
    }

}
