/**
 * Created by nimbekl on 11/18/17.
 */
public class factorial {
    public static void main(String[] args){
        int n = 6;
        int num = fact(n);
    }
    static int fact(int n){
       if(n == 0){
         return 1;
       } else {
           return n*fact(n-1);
       }
    }
}
