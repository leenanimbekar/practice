/**
 * Created by nimbekl on 10/26/17.
 */
import java.util.*;
public class carDistanceTravelManagement {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int total = s.nextInt();
        int road[][] = getDistanceArr(total,s);
        int rail[][] = getDistanceArr(total,s);
        int start = s.nextInt();
        int end = s.nextInt();
        int minCost[][] = initializeMinArray(road,start);
        int minCostByRoad[][] = minCostMatrix(minCost,road);
    }
    static int [][] initializeMinArray(int[][] arr,int start){
        int [][]minCost = new int[arr.length][arr.length];
        minCost[0][0] = arr[0][0];
        for(int j = start;j<arr.length;j++){
            minCost[0][j] = minCost[0][j-1]+arr[0][j];
            minCost[j][0] = minCost[j-1][0]+arr[j][0];
        }
        return minCost;
    }
    static int[][] minCostMatrix(int [][] minCost,int[][] arr){
        for(int i = 1 ;i<arr.length;i++) {
            for (int j = 1; j < arr.length; j++) {
                minCost[i][j] = Math.min(minCost[i-1][j],minCost[i][j-1])+arr[i][j];
            }
        }
        return minCost;
    }
    static int[][] getDistanceArr(int t,Scanner s){
        int arr[][] = new int[t][t];
        for(int i = 0 ;i<t;i++){
            for(int j = 0 ; j<t;j++){
                arr[i][j] = s.nextInt();
            }
        }
        return arr;
    }
}
