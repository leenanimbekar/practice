package WeekOfCode;

/**
 * Created by nimbekl on 11/18/17.
 */
import java.util.*;
public class HighwayConstruction {

    static long highwayConstruction(long n, int k) {
        long [][] a = new long[200][200];
        for(int i=0;i<200;i++)
        for(int j=0;j<200;j++)
            a[i][j]=-1;
        long ans=0;
        for (int i = 0; i <= k; ++i)
        {
            ans+=striling_num(k, i,a)*sum(n, i);
            ans%=1000000009;
        }
        return ans-((long)Math.pow(n,k))-1;
    }
    static long striling_num(int n, int k,long[][] chk)
    {
        if (chk[n][k]!=-1)
            return chk[n][k];
        if (n==0 && k==0)
            return 1;
        if (n==0 || k==0)
            return 0;
        chk[n][k]=striling_num(n - 1, k - 1,chk)+k*striling_num(n - 1, k,chk);
        return chk[n][k]%1000000009;
    }
    static long sum( long n, int k){
     n++;
     k++;
	 long ans=1;
	 long d=k;
        for (int i = 0; i < k; ++i){
		 long x=n-i;
		 long y=gcd(x,d);
            if(y != 0) {
                x /= y;
                d /= y;
            }
            ans*=x;
            ans%=1000000009;
        }
        return ans;
    }
    static long gcd(long n1,long n2){
        if(n2 == 0){ return n1; } return gcd(n2, n1%n2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long n = in.nextLong();
            int k = in.nextInt();
            long cost = highwayConstruction(n, k);
            System.out.println(cost);
        }
        in.close();
    }
}
