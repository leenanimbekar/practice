/**
 * Created by nimbekl on 10/26/17.
 */
public class validExpression {
    static public void main(String args[]){
        String tests[][] = {
                {"ab", "ab" },
                {"a*b" , "aaaaaab"},
                {"a*b*c*", "abc"},
                {"a*b*c" , "aaabccc"},
                {"^abc*b", "abccccb"},
                {"^abc*b", "abcbcccb"},
                {"^abcd$", "abcd"},
                {"^abc*abc$" , "abcabc"},
                {"^abc.abc$", "abczabc"},
                {"^ab..*abc$", "abyxxxxabc"}
        };
        for(int i = 0 ;i < tests.length;i++) {
            System.out.println("{"+tests[i][0]+","+tests[i][1]+"} "+ matches(tests[i][0],tests[i][1]));
        }
    }
    static boolean matches(String pattern,String str){
       boolean result = true;
       if(pattern== null || str== null){
           result = false;
       }
        else {
           int k = 0;
           for(int i = 0 ; i <pattern.length();i++){
                char c = pattern.charAt(i);
                if(isAlphabet(c)){
                    if(k < str.length()&& str.charAt(k++)==c && str.charAt(k++)==c){
                        result = true;
                        continue;
                    }else{
                        result = false;
                        break;
                    }
                }else{
                    result = handleSpclChar(pattern,c,str,i);
                }
           }
       }
       return result;
    }
    static boolean handleSpclChar(String pattern,char c, String string,int charPos){
        boolean result = false;
        switch (c){
            case '.':
                result = isAlphabet(string.charAt(charPos));
                break;
            case '^':
                if(charPos == 0){
                    int endIndex = pattern.length();
                    for(int i = 1 ;i < pattern.length();i++){
                        if(isAlphabet(pattern.charAt(i))){
                          continue;
                        }
                        else endIndex = i;
                        break;
                    }
                    result = string.startsWith(pattern.substring(1,endIndex));
                }
                break;
            case '*':
                if(charPos != 0) {
                    int charM = pattern.charAt(charPos - 1);
                    int startIndex = string.indexOf(charM);
                    if(startIndex > -1){
                        int lastIndex = string.lastIndexOf(charM);
                        string = string.substring(lastIndex+1);
                        result = startIndex > -1;
                    }
                }
                break;
            case '$':
                if(charPos == pattern.length()){
                int startIndex = pattern.length() - 1;
                for(int i = startIndex ;i > 0;i--){
                    if(isAlphabet(pattern.charAt(i))){
                        continue;
                    }
                    else startIndex = i;
                    break;
                }
                result = string.endsWith(pattern.substring(startIndex));
            }
            break;
        }
        return result;
    }
    static boolean isAlphabet(char c){
        return Character.isLetter(c);
    }
}
