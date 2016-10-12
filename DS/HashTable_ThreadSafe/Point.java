import java.util.Objects;
public class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  //You should write your hash function and equals method in this class
  //Two points are equal if they have the same x and y coordinates
  
  @Override
  public int hashCode() {
      return Objects.hash(this.x,this.y);
  }

  @Override
  public boolean equals(Object o) {

    if (o == this) {
      return true;
    }
    
    if (!(o instanceof Point)) {
        return false;
    }

    Point point = (Point) o;
    return this.x == point.x && this.y == point.y;

  }
  
    

}