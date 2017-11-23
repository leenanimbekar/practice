/**
 * Created by nimbekl on 10/27/17.
 */
public class printPossibleCombinations {
    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r)
    {
        if (index == r)
        {
            String s = new String();
            for (int j=0; j<r; j++) s = s+data[j];
            System.out.println(s);
            return;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    static void printCombination(int arr[], int n, int r)
    {
        int data[]=new int[r];

        combinationUtil(arr, data, 0, n-1, 0, r);
    }

    public static void main (String[] args) {
        int arr[] = {3,0,1};
        int r = 2;
        int n = arr.length;
        printCombination(arr, n, r);
    }
}
