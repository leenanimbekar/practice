/**
 * Created by nimbekl on 7/5/17.
 */
import java.util.*;
public class clockTimings {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int hours = in.nextInt();
        int minute = in.nextInt();

        if(1 <= hours && hours < 12 && 0 <= minute && minute < 60){
            if(minute == 0 || 60-minute==0){
                System.out.println(toWords(hours)+" o' clock");
            }
            else if (minute == 15){
                System.out.println("quarter past "+toWords(hours));
            }
            else if (minute == 45){
                System.out.println("quarter to "+toWords(hours+1));
            }
            else if (minute == 30){
                System.out.println("half past "+toWords(hours));
            }
            else if(minute <=30){
                System.out.println(toWords(minute)+" minutes past "+toWords(hours));
            }
            else if (minute > 30){
                System.out.println(toWords(60-minute)+" minutes to "+toWords(hours+1));
            }
        }
    }
    static String toWords(int number){
        final String[] ones = {
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen"
        };
        return number <=19 ? ones[number-1] : "twenty "+ones[((number-1) % 10)];
    }
}
