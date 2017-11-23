package WeekOfCode;

/**
 * Created by nimbekl on 11/13/17.
 */
import java.math.BigInteger;
import java.util.*;
public class LuckyPurchase implements Comparable<LuckyPurchase>{
    String name;
    BigInteger price;

    LuckyPurchase(String name,BigInteger price){
        this.name = name;
        this.price = price;
    }
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int totalTestCase = s.nextInt();
        ArrayList<LuckyPurchase> list = new ArrayList<>();
        for (int i = 0; i < totalTestCase; i++) {
            list.add(new LuckyPurchase(s.next(), s.nextBigInteger()));
        }
        Collections.sort(list);
        Iterator it = list.iterator();
        String result = "-1";
        while(it.hasNext()){
            LuckyPurchase entry = (LuckyPurchase)it.next();
            char [] price = String.valueOf(entry.price).toCharArray();
            Arrays.sort(price);
            String str = String.valueOf(price);
            if(str.startsWith("4") && str.endsWith("7") && !str.contains("5") && !str.contains("6")) {
                int count7 = (str.lastIndexOf("7") - (str.indexOf("7")))+1;
                int count4 = (str.lastIndexOf("4") - (str.indexOf("4")))+1;
                if (count7 == count4) {
                    result = entry.name;
                    break;
                }
            }
        }
     System.out.println(result);
    }
    public int compareTo(LuckyPurchase p1) {
        return price.compareTo(p1.price);
    }
}

