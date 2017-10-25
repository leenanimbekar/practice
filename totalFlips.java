/**
 * Created by nimbekl on 10/6/17.
 */
import java.util.*;
public class totalFlips {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int count = 0;
        char[] charArr = str.toCharArray();
        for(int i = 0; i<str.length()-1 ;i++){
           if(charArr[i] == charArr[i+1]){
               charArr[i+1] = flipChar(charArr[i+1]);
               count++;
           }
        }
        System.out.println(count);
    }
    public static char flipChar(char ch){
        return (ch =='0') ? '1' : '0';
    }
}
