package ru.stqa.pft.tasks.second;

public class Distance {

  public static void main(String[] args) {

    Point p1 = new Point(-2.4, 1);
    Point p2 = new Point(7, 5.8);

    System.out.println("Расстояние между двумя точками " + p1.x + "," + p1.y + " и " + p2.x + "," + p2.y +
            " на плоскости = " + p1.distance(p2));
  }

}
