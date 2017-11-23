/**
 * Created by nimbekl on 11/2/17.
 * Its length is at least 6.
 * It contains at least one digit.
 * It contains at least one lowercase English character.
 * It contains at least one uppercase English character.
 * It contains at least one special character. The special characters are: !@#$%^&*()-+
 */
import java.util.*;
public class StrongPassword {
    static int minimumNumber(int n, String password) {
        int isDigit=0,isLowerCase=0,isUpperCase=0,isSpecialChar=0,result=0;
            for(char c:password.toCharArray()){
                if(Character.isDigit(c)){
                    isDigit++;
                }else if(Character.isLowerCase(c)){
                    isLowerCase++;
                }else if(Character.isUpperCase(c)){
                    isUpperCase++;
                }
                else {
                    String str = String.valueOf(c);
                    if("!".equals(str) || "@".equals(str) || "#".equals(str) ||
                       "$".equals(str) || "%".equals(str) || "^".equals(str) ||
                       "&".equals(str) || "*".equals(str) || "-".equals(str) ||
                       "+".equals(str) || "(".equals(str) || ")".equals(str)){
                        isSpecialChar++;
                    }
                }
            }
            if (isDigit == 0){
                result ++;
            }
            if(isLowerCase == 0){
                result++;
            }
            if(isUpperCase == 0){
                result++;
            }
            if(isSpecialChar == 0){
                result++;
            }
        if(result+password.length()<6){
            return 6-password.length();
        } else return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
    }
}
