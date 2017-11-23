/**
 * Created by nimbekl on 10/26/17.
 */
import java.util.*;
public class carDistManag {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        double speedArr[] = new double[N];
        double consumption[] = new double[N];
        for(int i=0 ;i <N;i++){
            speedArr[i] = s.nextInt();
        }
        for(int i=0 ;i <N;i++){
            consumption[i] = s.nextInt();
        }
        int fuelAvail = s.nextInt();
        double [] distTravelled = new double[N];
        double max = 0;
        for(int i=0 ;i <N;i++){
            distTravelled[i] = (fuelAvail/consumption[i])*speedArr[i];
            if(distTravelled[i] > max){
                max = distTravelled[i];
            }
        }
        max = (long)(max*1000)/1000.0;
        System.out.println(String.valueOf(max));
    }
}
