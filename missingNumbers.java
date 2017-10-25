import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by nimbekl on 6/3/17.
 */
public class missingNumbers {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
            int listAtotal = s.nextInt();
            HashMap<Integer, Integer> mapA = new HashMap<>(listAtotal);
            createList(mapA,listAtotal);
            int listBtotal = s.nextInt();
            HashMap<Integer, Integer> mapB = new HashMap<>(listBtotal);
            createList(mapB,listBtotal);
        }
     static HashMap createList(HashMap map,int listTotal){
         Scanner s = new Scanner(System.in);
            for(int i = 0 ;i<listTotal;i++){
                int nextNumber = s.nextInt();
                if(map.containsKey(nextNumber)){
                    int count = (int)map.get(nextNumber);
                    map.put(nextNumber,count+1);
                }
                else map.put(nextNumber,1);
            }
        return map;
    }
}
