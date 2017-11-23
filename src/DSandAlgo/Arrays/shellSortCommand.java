package DsAndAlgo.Array;

/**
 * Created by nimbekl on 11/13/17.
 */
import java.math.*;
import java.util.*;
public class shellSortCommand {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        List<String[]> matrix = new ArrayList<>();
        s.nextLine();
        for(int i=0;i<row;i++){
         matrix.add(s.nextLine().split(" "));
        }
        int col = s.nextInt();
        String reversal = s.next();
        String orderAs = s.next();

        if(orderAs.equals("lexicographic") && reversal.equals("false")){
            Collections.sort(matrix,new lexicographicSort(col-1));
        }else if(orderAs.equals("lexicographic") && reversal.equals("true")){
            Collections.sort(matrix,new lexicographicSortReverse(col-1));
        }else if(orderAs.equals("numeric") && reversal.equals("false")){
            Collections.sort(matrix,new numericSort(col-1));
        } else Collections.sort(matrix,new numericSortReverse(col-1));

        for(String [] str:matrix){
            for(String string:str) {
                System.out.print(string+ " ");
            }
            System.out.println();
        }
    }
    static public class lexicographicSort implements Comparator<String[]>{
        int col = 0;
        lexicographicSort(int col){
            this.col = col;
        }
        @Override
        public int compare(String[] s1, String[] s2) {
            return s1[col].compareTo(s2[col]);
        }
    }
    static public class lexicographicSortReverse implements Comparator<String[]>{
        int col = 0;
        lexicographicSortReverse(int col){
            this.col = col;
        }
        @Override
        public int compare(String[] s1, String[] s2) {
            return s2[col].compareTo(s1[col]);
        }
    }
    static public class numericSort implements Comparator<String[]>{
        int col = 0;
        numericSort(int col){
            this.col = col;
        }
        @Override
        public int compare(String[] s1, String[] s2) {
            BigInteger str1 = new BigInteger(s1[col]);
            BigInteger str2 = new BigInteger(s2[col]);

            if(String.valueOf(str1).length() < String.valueOf(str2).length()){
                return -1;
            } if(String.valueOf(str1).length() > String.valueOf(str2).length()){
                return 1;
            }else {
                return str1.compareTo(str2);
            }
        }
    }
    static public class numericSortReverse implements Comparator<String[]>{
        int col = 0;
        numericSortReverse(int col){
            this.col = col;
        }
        @Override
        public int compare(String[] s1, String[] s2) {
            BigInteger str1 = new BigInteger(s1[col]);
            BigInteger str2 = new BigInteger(s2[col]);
            if(String.valueOf(str1).length() > String.valueOf(str2).length()){
                return -1;
            } if(String.valueOf(str1).length() < String.valueOf(str2).length()){
                return 1;
            }else {
                return str2.compareTo(str1);
           }
        }
    }
}
