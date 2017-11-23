import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static boolean isSquare(int []n) {
        for(int i=1; i<n.length; i++){
            if(n[0] != n[i]){
                return false;
            }
        }
      return true;
    }
    static boolean isRectangle(int []n) {
        if(n[0] == n[2] && n[1] == n[3]){
          return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int rec = 0,square = 0,other = 0;
        while (in.hasNext()) {
        int []_n = new int[4];
            for (int i = 0; i <= 3; i++) {
                _n[i] = in.nextInt();
            }
            if (isRectangle(_n)) {
                rec = rec + 1;
            } else if (isSquare(_n)) {
                square = square + 1;
            } else {
                other = other + 1;
            }
        }
        System.out.println(rec +" "+square+" "+other);
    }
}
