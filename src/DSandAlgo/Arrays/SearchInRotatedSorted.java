package DsAndAlgo.Array;

/**
 * Created by nimbekl on 11/7/17.
 */
public class SearchInRotatedSorted {
    public static void main(String args[]){
        int [] arr = {16,19,21,25,3,5,8,10};
        int number = 19;
        System.out.println(findNumber(arr,number,0,arr.length-1));
    }
    static int findNumber(int arr[],int num,int low,int high){
      int mid;
        while(low <= high) {
            mid = low+((high-low)/2);
            if (arr[mid] == num) {
                return mid;
            }
            if (arr[mid] <= arr[high]) {
                if(num > arr[mid] && num <= arr[high]){
                    low = mid+1;
                }else high = mid-1;
            }else{
                if(arr[low] <= num && num <arr[mid]){
                    high=mid-1;
                }else low = mid+1;
            }
        }
      return -1;
    }
}
