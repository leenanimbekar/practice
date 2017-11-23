/**
 * Created by nimbekl on 10/27/17.
 */
import com.sun.tools.corba.se.idl.InterfaceGen;
import com.sun.tools.corba.se.idl.StringEntry;

import java.util.*;
class pair{
    int a;
    int b;
    pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}

public class pairOfDigits {
    public static void main(String args[]){
       Scanner s = new Scanner(System.in);
        int totalTestCases = s.nextInt();
        int [] numbers = new int[totalTestCases];
        for(int i = 0;i<totalTestCases;i++){
            numbers[i] = s.nextInt();
        }
        for(int i = 0;i<totalTestCases;i++){
            ArrayList<pair> totalPairs = findPairs(numbers[i]);
            System.out.println("TEST #"+i+1);
            System.out.println(totalPairs.size()+" pairs found");
            for(pair p :totalPairs){
                System.out.println(p.a +" + "+p.b);
            }
        }
    }
    static boolean isValid(int n){
        return (n > 9);
    }
    static boolean isDoubleDigit(int n){
        return (n > 9 && n < 100);
    }
    static ArrayList<pair> findPairs(int sum){
        ArrayList<pair> lst = new ArrayList();
        if(isValid(sum)){
            if(isDoubleDigit(sum)) {
                int b = sum % 10;
                int a = sum - b;
                pair p = new pair(a, b);
                lst.add(p);
            } else {
            for(int i = sum-1; i>99;i--){
                int a = i;
                char[] ch = String.valueOf(a).toCharArray();
                int [] numbers =  new int[ch.length];
                for(int k = 0;k <ch.length;k++){
                    numbers[k] = ch[k] - '0';
                }
                TreeSet<Integer> bPermutations = createCombination(numbers);
                for(int b :bPermutations) {
                    if (sum - a == b) {
                        pair p = new pair(a, b);
                        lst.add(p);
                    }
                }
            }
            }
        }
        return lst;
    }
    static TreeSet<Integer> createCombination(int[] arr){
        int r = arr.length-1;
        int data[] = new int[r];
        TreeSet<Integer> tset = new TreeSet<>();
        combinationUtil(arr, data, 0, r, 0, r,tset);
        return tset;
    }
    static void combinationUtil(int[] arr,int[] data,int start,int end,int index,int r,TreeSet<Integer> tset){
        if(index == r){
            String s = new String();
            for (int j=0; j<r; j++){
                s = s+data[j];
            }
            tset.add(Integer.valueOf(s));
            return;
        }
        for(int p = start;p <=end && end-p+1>=r-index;p++){
            data[index] = arr[p];
            combinationUtil(arr,data,p+1,end,index+1,r,tset);
        }
    }
}