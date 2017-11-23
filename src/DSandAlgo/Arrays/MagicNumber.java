package DsAndAlgo.Array;

/**
 * Created by nimbekl on 11/8/17.
 */
public class MagicNumber {
    public static void main(String args[]){
        int n=5;
        int pow=5,value=0;
        while(n!=0){
            if((n&1)!=0){
              value+=pow;
            }
            pow*=5;
            n>>=1;
        }
        System.out.print(value);
    }
}
