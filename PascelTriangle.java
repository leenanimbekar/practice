/**
 * Created by nimbekl on 11/21/17.
 */
public class PascelTriangle {
    public static void main(String args[]){
        int n = 5;
        for(int i = 1;i<=n;i++){
            int c = 1;
            for(int j = 1;j<i;j++){
              System.out.print(c+" ");
              c = c * (i-j)/j;
            }
            System.out.print(1);
            System.out.println();
        }
    }
}
