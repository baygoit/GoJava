import factories.CircleFactory;
import factories.RectangleFactory;
import factories.TriangleFactory;
import groups.Group;
import serializers.SerializerType;
import shapes.*;
import java.util.Collections;

/**
 * Created by Alex on 22.03.2015.
 */
public class TestFunctionality {
  private static TriangleFactory triangleFactory = new TriangleFactory();
  private static RectangleFactory rectangleFactory = new RectangleFactory();
  private static CircleFactory circleFactory = new CircleFactory();

  public static void main(String[] args) {
    Point point1 = new Point(1, 1);
    Point point2 = new Point(2, 3);
    Point point3 = new Point(-1, 4);
    Point point4 = new Point(3, -2);

    Group mainGroup = new Group();
    Triangle triangle1 = triangleFactory.getShape(point1, point2, point3);
    mainGroup.add(triangle1);

    Group subGroup1 = new Group();
    mainGroup.add(subGroup1);
    Group subGroup2 = new Group();
    mainGroup.add(subGroup2);

    Triangle triangle2 = triangleFactory.getShape(point2, point3, point4);
    Circle circle1 = circleFactory.getShape(point2, 5);
    Rectangle rectangle1 = rectangleFactory.getShape(point3, 5, 10);
    Collections.addAll(subGroup1, triangle2, circle1, rectangle1);

    Circle circle2 = circleFactory.getShape(point4, 3);
    Rectangle rectangle2 = rectangleFactory.getShape(point4, 6, 2);
    Collections.addAll(subGroup2, circle2, rectangle2);

    System.out.println(mainGroup.serialize(SerializerType.XML));
    System.out.println();
    System.out.println(mainGroup.serialize(SerializerType.JSON));
  }
}
