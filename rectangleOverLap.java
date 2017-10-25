/**
 * Created by nimbekl on 10/13/17.
 */
import java.util.*;
public class rectangleOverLap {
    public static void main(String args[]){
        Point l1 = new Point(0, 10);
        Point r1 = new Point(10, 0);
        Point l2 = new Point(5, 5);
        Point r2 = new Point(15, 0);
        Rectangle first = new Rectangle(l1,r1);
        Rectangle second = new Rectangle(l2,r2);
        if(first.isOverLapping(second)){
            System.out.println("Overlapping");
        }else System.out.println("Not Overlapping");
    }
}
class Point{
    int x,y;
    Point(int x ,int y){
        this.x = x;
        this.y = y;
    }
}

class Rectangle{
    private final Point topLeft;
    private final Point bottomRight;
    Rectangle(Point topLeft ,Point bottomRight){
        this.bottomRight = bottomRight;
        this.topLeft = topLeft;
    }
    public boolean isOverLapping(Rectangle rect){
        if(this.topLeft.x > rect.bottomRight.x ||
           this.bottomRight.x < rect.topLeft.x ||
           this.topLeft.y < rect.bottomRight.y ||
           this.bottomRight.y > rect.topLeft.y){
            return false;
        }
        return true;
    }
}