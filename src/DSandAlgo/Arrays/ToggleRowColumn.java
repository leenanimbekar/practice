package DsAndAlgo.Array;

/**
 * Created by nimbekl on 11/10/17.
 */
public class ToggleRowColumn {
    public static void main(String args[]){
        int m = 4,n = 4;
        int arr[][] = {{0, 1, 1, 1},{0, 0, 1, 1},{1, 1, 1, 1},{0, 0, 0, 0}};
        /*for(int i = 0;i<m;i++){
          for(int j =0;j<n;j++){
             arr[m][n]=
          }
        }*/
        int max=-1;
        int maxCount = -1;
        int minJ=-1;
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(minJ >j|| minJ==-1) {
                    if (arr[i][j] == 1) {
                        if (maxCount < n - j) {
                            maxCount = n - j;
                            max = i;
                            minJ = j;
                            break;
                        }
                    }
                } else break;
            }
            if(maxCount == n){
                break;
            }
        }
        System.out.println("Row "+max+" with total 1's = "+maxCount);
        toggle(arr,1,2,m,n);
    }
    static int[][] toggle(int[][] arr,int row,int col,int m,int n){
        //row 0,col 2
        int i = 0;
        int j = m-1;
       while(i < m && j < n){
           int temp = arr[row][i];
           arr[row][i] = arr[j][col];
           arr[j][col] = temp;
           i++;
           j--;
       }
       return arr;
    }
}
