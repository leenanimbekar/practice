package WeekOfCode;

/**
 * Created by nimbekl on 11/20/17.
 */
import java.util.*;
public class Airports {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int totalTestCases = s.nextInt();
        for(int i = 0;i<totalTestCases;i++){
            int positions = s.nextInt();
            int diff = s.nextInt();
            int problem[] = new int[positions];
            for(int j = 0;j < positions;j++) {
               int k  = s.nextInt();
                problem[j] = k;
            }
            int result[] = new Airports().getResult(problem,diff);
            for(int x=0;x<positions;x++){
                System.out.print(result[x]+" ");
            }
            System.out.println();
        }
    }
    int[] getResult(int[] problems,int minDistance){
        int result[] = new int [problems.length];
        result[0] = 0;
        for(int x = 1;x<problems.length;x++){
            int cost = 0;
            int num = problems[x];
            Set<Integer> set = new HashSet<>();
            for(int i = 0;i<x;i++){
                if(!set.contains(problems[i])) {
                    int diff = Math.abs(problems[i] - num);
                    if(diff != 0 || problems[i] == 0) {
                        if (diff == 1) {
                            cost++;
                        } else cost += minDistance - diff;
                        set.add(problems[i]);
                    }
                }
            }
            result[x] = cost;
        }
        return result;
    }
}
