/**
 * Created by nimbekl on 10/12/17.
 */
import java.util.*;
public class minButtonClicks {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int totalChannelToSee = s.nextInt();
        int[] channelsToVisit = new int[totalChannelToSee];
        for(int i = 0 ;i<totalChannelToSee;i++){
            channelsToVisit[i] = s.nextInt();
        }
        int clicks = String.valueOf(channelsToVisit[0]).length();
        int prev = 0;
        int plus = 0;
        int minus = 0;

        for(int i = 1 ;i<totalChannelToSee;i++){
            if(channelsToVisit[i] == plus || (channelsToVisit[i] == minus) || (prev == channelsToVisit[i])){
                clicks++;
            } else if((channelsToVisit[i] > channelsToVisit[i-1]) && channelsToVisit[i] - channelsToVisit[i-1] < String.valueOf(channelsToVisit[i]).length()){
                clicks = clicks+(channelsToVisit[i] - channelsToVisit[i-1]);
            } else if((channelsToVisit[i-1] > channelsToVisit[i]) && channelsToVisit[i-1] - channelsToVisit[i] < String.valueOf(channelsToVisit[i]).length()){
                clicks = clicks+(channelsToVisit[i-1] - channelsToVisit[i]);
            } else if(channelsToVisit[i] == prev - 1 || channelsToVisit[i] == prev + 1){
                clicks = clicks+2;
            } else {
                clicks = clicks + String.valueOf(channelsToVisit[i]).length();
            }
            plus = channelsToVisit[i] + 1;
            minus = channelsToVisit[i] - 1;
            prev = channelsToVisit[i-1];
        }

        System.out.println(clicks);
    }
}
