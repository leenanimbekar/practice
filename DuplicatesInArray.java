/**
 * Created by nimbekl on 11/6/17.
 */
public class DuplicatesInArray {
    public static void main(String args[]){
        String str = "aabbbbs";
        int[] count = new int[256];
        for(int i = 0;i<str.length();i++){
            count[str.charAt(i)]++;
        }
        for(int i = 0;i<count.length;i++){
           if(count[i] >= 2){
            System.out.print((char)(i) + " ");
           }
        }
    }
}
