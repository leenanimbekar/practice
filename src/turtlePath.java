
import java.util.*;
import java.lang.*;
import java.io.*;

class turtlePath
{
    public static void main (String[] args) {

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int arr[][] = new int[m][n];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        ArrayList<int[]> lst =  new ArrayList();
        //(x + 1, y ), ( x , y + 1 ) and ( x + 1, y + 1 )
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int[] valArr = new int[2];
                if(isPrime(arr[i+1][j])){
                    valArr[0]= i+1;
                    valArr[1]= j;
                    lst.add(valArr);
                }
                else if(isPrime(arr[i][j+1])){
                    valArr[0]= i;
                    valArr[1]= j+1;
                    lst.add(valArr);
                }
                else if(isPrime(arr[i+1][j+1])){
                    valArr[0]= i+1;
                    valArr[1]= j+1;
                    lst.add(valArr);
                }
            }
        }
    }
    static boolean isPrime(int n)
    {
        if (n <= 1)  return false;
        if (n <= 3)  return true;

        if (n%2 == 0 || n%3 == 0) return false;

        for (int i=5; i*i<=n; i=i+6)
            if (n%i == 0 || n%(i+2) == 0)
                return false;

        return true;
    }
}
 