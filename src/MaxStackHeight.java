/**
 * Created by nimbekl on 11/10/17.
 */
import java.util.*;
public class MaxStackHeight {
    public static void main(String args[]){
        Box arr[] = { new Box(4, 6, 7), new Box(1, 2, 3), new Box(4, 5, 6), new Box(10, 12, 32)};
        System.out.print(maxHeight(arr));
    }
    static int maxHeight(Box arr[]) {
        int maxHeight = 0;
        int size = arr.length * 3;
        Box newArr[] = new Box[size];
        int index = 0;
        int i = 0;
        while (i < size) {
            newArr[i] = arr[index];
            i++;
            newArr[i] = new Box(Math.max(arr[index].depth, arr[index].width), arr[index].height, Math.min(arr[index].depth, arr[index].width));
            i++;
            newArr[i] = new Box(Math.min(arr[index].depth, arr[index].width), arr[index].height, Math.max(arr[index].depth, arr[index].width));
            i++;
            index++;
        }
        Arrays.sort(newArr);
        int msh[] = new int[size];
        for (int h = 0; h < size; h++ )
            msh[h] = newArr[h].height;
        for(int x = 1; x < size; x++){
            for (int y = 0; y < i; y++) {
                if(newArr[x].width < newArr[y].width && newArr[x].depth<newArr[y].depth && msh[x]< msh[y]+newArr[x].height){
                    msh[x] = msh[y]+newArr[x].height;
                }
            }
        }
        for ( int s = 0; s < size; s++ )
            if ( maxHeight < msh[s] )
                maxHeight = msh[s];
        return maxHeight;
    }
    static class Box implements Comparable<Box>{
        int height;
        int depth;
        int width;
        Box(int height,int depth,int width){
           this.height = height;
           this.width = width;
           this.depth = depth;
        }
        public int compareTo(Box b){
            if(depth*height*width == b.depth*b.height*b.width){
                return 0;
            }else if(depth*height*width < b.depth*b.height*b.width){
                return 1;
            }else return -1;
        }
    }
}
