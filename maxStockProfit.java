/**
 * Created by nimbekl on 10/17/17.
 */
public class maxStockProfit {
    public static void main(String args[]){
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        int i = 0,j = 1 , max = 0;
        int size = arr.length;
            while(i < size && j < size){
                int diff = arr[j] - arr[i];
                if(max < diff){
                    max =  diff;
                }
                else {
                    System.out.println("Profit - "+max+" Buy on Day "+ i +" Sell on "+ (j-1));
                    i = j;
                    j = i;
                }
                if(j == size-1 && i !=j){
                    System.out.println("Profit - "+max+" Buy on Day "+ i +" Sell on "+ (j));
                }
                j++;
            }
        }
}
