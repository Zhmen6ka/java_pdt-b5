package ru.stqa.ptf.tasks.second;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.tasks.second.Point;

public class PointTests {
  @Test
  public void DistanceTest1(){
    Point p1 = new Point(-2.4, 1);
    Point p2 = new Point(7, 5.8);
    Assert.assertEquals(p1.distance(p2), 10.554619841567009);
  }

  @Test
  public void DistanceTest2(){
    Point p1 = new Point(-2.4, 1);
    Point p2 = new Point(7, 5.8);
    Assert.assertEquals(p1.distance(p2), 10.554619);
  }

  @Test
  public void DistanceTest3(){
    Point p1 = new Point(-2.4, 1);
    Point p2 = new Point(7, 5.8);
    Assert.assertEquals(p1.distance(p2), 10.0458);
  }
}
