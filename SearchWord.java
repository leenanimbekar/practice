/**
 * Created by nimbekl on 11/5/17.
 */
public class SearchWord {
    public static void main(String[] args) {
        String [] stringArr = {"GEEKSFORGEEKS", "GEEKSQUIZGEEK", "IDEQAPRACTICE"};
        String str = "GEEKS";
        char[] strArr = str.toCharArray();
        char [][] charArr = new char[stringArr.length][stringArr[0].length()];
        for(int i = 0;i<stringArr.length;i++){
            charArr[i] = stringArr[i].toCharArray();
        }
        for(int i = 0;i<stringArr.length;i++){
            for(int j = 0;j<stringArr[0].length();j++){
              if(charArr[i][j] == strArr[0]){
                  boolean result = false;
                  if(stringArr[0].length()-j>=strArr.length) {
                      for (int k = 1; k < str.length(); k++) {
                          if (charArr[i][j + i] == strArr[k]) {
                              result = true;
                          } else {
                              result = false;
                              break;
                          }
                      }
                      if (result) {
                          System.out.println("pattern found at " + i + "," + j);
                      }
                  }
                  if(i>=strArr.length){

                  }
              }
            }
        }
    }
}
