package DsAndAlgo.Array;

/**
 * Created by nimbekl on 11/8/17.
 */
public class TwoEqualSumSubArrays {
    public static void main(String args[]){
        int arr[] = {1 , 2 , 3 , 4 , 5 , 5};
        int leftToRightSum=0;
        for(int i = 0;i<arr.length;i++){
            leftToRightSum = leftToRightSum+arr[i];
        }
        int rightSum=0;
        int splitPoint = -1;
        for(int i = arr.length-1;i>=0;i--){
            rightSum =  rightSum+arr[i];
            leftToRightSum = leftToRightSum-arr[i];
            if(leftToRightSum == rightSum){
                splitPoint = i;
                break;
            }
        }
        if(splitPoint == -1 || splitPoint == arr.length){
            System.out.println("Not Possible");
        }else {
            for(int i = 0;i<=splitPoint-1;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            for(int i = splitPoint;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
