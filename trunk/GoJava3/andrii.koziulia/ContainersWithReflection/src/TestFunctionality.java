import groups.Group;
import serializers.SerializerType;
import shapes.*;
import java.util.Collections;

/**
 * Created by Alex on 22.03.2015.
 */
public class TestFunctionality {

  public static void main(String[] args) {
    Point point1 = new Point(1, 1);
    Point point2 = new Point(2, 3);
    Point point3 = new Point(-1, 4);
    Point point4 = new Point(3, -2);

    Group mainGroup = new Group();
    Triangle triangle1 = new Triangle(point1, point2, point3);
    mainGroup.add(triangle1);

    Group subGroup1 = new Group();
    mainGroup.add(subGroup1);
    Group subGroup2 = new Group();
    mainGroup.add(subGroup2);

    Triangle triangle2 = new Triangle(point2, point3, point4);
    Circle circle1 = new Circle(point2, 5);
    Rectangle rectangle1 = new Rectangle(point3, 5, 10);
    Collections.addAll(subGroup1, triangle2, circle1, rectangle1);

    Circle circle2 = new Circle(point4, 3);
    Rectangle rectangle2 = new Rectangle(point4, 6, 2);
    Collections.addAll(subGroup2, circle2, rectangle2);

    CombinationFigure combinationFigure = new CombinationFigure(circle1, rectangle1);
    System.out.println(mainGroup.serialize(SerializerType.XML));
    System.out.println();
    System.out.println(combinationFigure.serialize(SerializerType.XML));
    System.out.println();
    System.out.println(mainGroup.serialize(SerializerType.JSON));
  }
}
