import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by nimbekl on 9/15/17.
 */
public class winKingdom {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(str.charAt(returnPostion(str)));
    }

    public static int returnPostion(String str) {
        int p = -1,k;
        int MAX_CHAR = 256;
        int hash[] = new int[MAX_CHAR];
        int pos[] = new int[MAX_CHAR];
        for(int i=0;i<str.length();i++){
            k = str.charAt(i);
            if(hash[k] == 0){
               hash[k]++;
                pos[k] = i;
            }
            else if(hash[k] == 1){
                hash[k]++;
            }
        }
        for(int i= 0 ;i<MAX_CHAR;i++){
            if(hash[i]==2){
                if(p == -1){
                    p = pos[i];
                }else if(p>pos[i]){
                    p = pos[i];
                }
            }
        }
        return p;
    }
}
