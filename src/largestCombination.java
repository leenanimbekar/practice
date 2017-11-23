import java.util.*;

/**
 * Created by nimbekl on 10/5/17.
 */
public class largestCombination {
    public static void main(String args[]){
      Scanner s = new Scanner(System.in);
        Vector<String> v = new Vector<>();
        v.add("54");
        v.add("546");
        v.add("548");
        v.add("60");
        printLargest(v);
    }
    private static void printLargest(Vector arr){
        Collections.sort(arr,new Comparator<String>(){
            public int compare(String x,String y){
                String xy = x + y;
                String yx = y + x;

                return xy.compareTo(yx)>0?-1:1;
            }
        });
        Iterator i = arr.iterator();
        while(i.hasNext()){
            System.out.print(i.next());
        }
    }
}
