package ru.stqa.pft.tasks.second;

public class Distance {

  public static void main(String[] args) {

    Point p1 = new Point();
    Point p2 = new Point();
    p1.x = -2.4;
    p1.y = 1;
    p2.x = 7;
    p2.y = 5.59;

    System.out.println("Расстояние между двумя точками " + p1.x + "," + p1.y + " и " + p2.x + "," + p2.y +
            " на плоскости = " + distance(p1, p2));
  }

  public static double distance(Point p1, Point p2){
    //double x1 = 2;
    //double x2 = 4;
    //double y1 = 3;
   // double y2 = 5;
    return Math.sqrt((p1.x - p2.x) * (p1.y - p2.y) + (p1.x - p2.x) * (p1.y - p2.y));
  }

}
