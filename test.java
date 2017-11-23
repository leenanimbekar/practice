/**
 * Created by nimbekl on 10/10/17.
 */
import java.util.*;
public class test {
        public static void main(String args[]){
            Dog d= new Dog();
            int w = (int)888.8;
            System.out.println(w);
            byte x = (byte)100L;
            System.out.println(x);
            long y = (byte)100;
            System.out.println(y);
            byte z = (byte)100L;
            System.out.println(z);
            for(int i=0;;i++){
                System.out.println(i);
            }
        }
}
class Animal{
    Animal(){System.out.println("animal is created");}
}
class Dog extends Animal{
    Dog(){
        //super();
        System.out.println("dog is created");
    }
}
