import java.util.Scanner;

/**
 * Created by nimbekl on 10/13/16.
 */
class tests{
    String s ;
    int i;
    tests(String s,int i){
       this.i = i;
        this.s = new String(s);
    }
    boolean equals(tests test){
        if(this.s == test.s && this.i == test.i){
          return true;
        }else return false;
    }
    public int hashCode(){
        int hash = 5;
        hash = hash + (this.s != null ? this.s.hashCode() : 0);
        hash = hash + (int) (this.i ^ (this.i >>> 32));
        hash = hash + this.i;
        return hash;
    }
}
/*interface A {
    void m();
    default void k(){

    };
}
interface B extends A {
    default void k(){

    };
}
interface C extends A {
    default void k(){

    };
}
abstract class G {
    abstract void k();
}
class D extends G implements B, C {
    public void m(){
        System.out.println("something");
    }
   public void k(){

    };
}*/
class A{
   void method1(){
     System.out.print("somethong");
   }
   void method2(){
       System.out.print("somethong !!!");
   }
}
class B extends A{
    void method2(){
        method1();
    }
    void method1(int a){
        System.out.print("somethongssss");
    }
}
public class practice{
    public static void main(String args[]){
       /*Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        for(int i = number ;i<Math.pow(10,i);i++) {
            String x = i % 10 + "" + i / 10;
            int newNumber = Integer.valueOf(x);
            if (newNumber == (i % 10) * i) {
                System.out.println(i);
            }
        }*/
        A a = new B();
        a.method2();
        tests t1 = new tests("test",10);
        tests t2 = new tests("test",10);
        System.out.println(t1.equals(t2));
        System.out.println(t1 == t2);
    }
}
