import java.util.Scanner;

/**
 * Created by nimbekl on 10/5/17.
 */
public class firstNonRepeatingChar {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(str.charAt(countNonRepeatingString(str)));
    }
    public static int countNonRepeatingString(String s){
        int position = 0;
        int charMax = 256;
        int k;
        int pos[] = new int[charMax];
         for(int i = 0 ; i<s.length();i++){
             k = s.charAt(i);
            if(pos[k] == 0){
                pos[k] = 1;
            }else{
                pos[k]++;
            }
        }
        for(int i = 0 ; i<charMax;i++){
            if(pos[i] == 1){
              position = pos[i];
                break;
            }
        }
        return position;
    }
}
