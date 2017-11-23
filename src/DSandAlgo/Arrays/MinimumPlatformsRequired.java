package DsAndAlgo.Array;

/**
 * Created by nimbekl on 11/7/17.
 */
public class MinimumPlatformsRequired {
    public static void main(String args[]){
        int arr[] = {100, 140, 150, 200, 215, 400};
        int dep[] = {110, 300, 220, 230, 315, 600};
        System.out.println(findPlatformsRequiredForStation(arr,dep));
    }
    static int findPlatformsRequiredForStation(int[] arr,int[] dep){
      int n = arr.length;
        int platformNeeded=0,maxPlatform=0;
        int i = 0,j = 0;
        while(i<n && j<n){
            if(arr[i]<dep[j]){
                platformNeeded++;
                i++;
                if(platformNeeded>maxPlatform){
                    maxPlatform = platformNeeded;
                }
            }else {
                platformNeeded--;
                j++;
            }
        }
        return maxPlatform;
    }
}
