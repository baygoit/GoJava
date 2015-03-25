package ua.goit.tests;

import static org.junit.Assert.*;


import org.junit.Test;
import ua.goit.factories.*;
import ua.goit.model.*;
import ua.goit.serializers.*;

public class TestCases {
  private static GroupShapesFactory groupFactory = new GroupShapesFactory();
  private static TriangleFactory triangleFactory = new TriangleFactory();
  private static CircleFactory circleFactory = new CircleFactory();
  private static SquareFactory squareFactory = new SquareFactory();


  public Triangle newTestTriangle() {
    Point point1 = new Point(1, 1);
    Point point2 = new Point(2, 2);
    Point point3 = new Point(3, 3);
    Triangle triangle = triangleFactory.getShapeContainer(point1, point2, point3);

    return triangle;
  }

  public GroupShapes newTestGroup() {
    GroupShapes group = groupFactory.getShapeContainer();
    Point point1 = new Point(1, 1);
    Point point2 = new Point(2, 2);
    Point point3 = new Point(3, 3);

    Triangle triangle = triangleFactory.getShapeContainer(point1, point2, point3);
    group.add(triangle);

    return group;
  }

  @Test
  public void testSimpleXML() {

    Triangle triangle = newTestTriangle();

    Serializer xmlSerializer = MapService.getSerializer(SerializerType.XML);
    String shapeStringXML = xmlSerializer.serialize(triangle);

    String expectedResult = "<triangle><point1><x>1</x><y>1</y></point1><point2><x>2</x><y>2</y></point2>" +
            "<point3><x>3</x><y>3</y></point3></triangle>";

    assertEquals(expectedResult, shapeStringXML);
  }

  @Test
  public void testSimpleJSON() {

    Triangle triangle = newTestTriangle();

    Serializer jsonSerializer = MapService.getSerializer(SerializerType.JSON);
    String shapeStringJSON = jsonSerializer.serialize(triangle);
    String expectedResult = "{\"type\":\"TRIANGLE\",\"point1\":{\"x\":1,\"y\":1},\"point2\":{\"x\":2,\"y\":2}" +
            ",\"point3\":{\"x\":3,\"y\":3}}";
    assertEquals(expectedResult, shapeStringJSON);
  }

  @Test
  public void testGroupXML() {

    GroupShapes groupShapes = newTestGroup();

    Serializer xmlSerializer = MapService.getSerializer(SerializerType.XML);
    String shapeStringXML = xmlSerializer.serialize(groupShapes);

    String expectedResult = "<group><triangle><point1><x>1</x><y>1</y></point1><point2><x>2</x><y>2</y></point2>" +
            "<point3><x>3</x><y>3</y></point3></triangle></group>";

    assertEquals(expectedResult, shapeStringXML);
  }

  @Test
  public void testGroupJSON() {

    GroupShapes groupShapes = newTestGroup();

    Serializer jsonSerializer = MapService.getSerializer(SerializerType.JSON);
    String shapeStringJSON = jsonSerializer.serialize(groupShapes);
    String expectedResult = "{\"type\":\"GROUP\",\"shapesList\":[{\"type\":\"TRIANGLE\",\"point1\":" +
            "{\"x\":1,\"y\":1},\"point2\":{\"x\":2,\"y\":2},\"point3\":{\"x\":3,\"y\":3}}]}";
    assertEquals(expectedResult, shapeStringJSON);
  }

  public GroupShapes bigTestGroup() {
    Point point1 = new Point(1, 1);
    Point point2 = new Point(2, 3);
    Point point3 = new Point(-1, 4);
    Point point4 = new Point(3, -2);

    GroupShapes mainGroup = groupFactory.getShapeContainer();
    Triangle triangle1 = triangleFactory.getShapeContainer(point1, point2, point3);
    mainGroup.add(triangle1);

    GroupShapes subGroup1 = groupFactory.getShapeContainer();
    mainGroup.add(subGroup1);
    GroupShapes subGroup2 = groupFactory.getShapeContainer();
    mainGroup.add(subGroup2);

    Triangle triangle2 = triangleFactory.getShapeContainer(point2, point3, point4);
    Circle circle1 = circleFactory.getShapeContainer(point2, 5);
    Square square1 = squareFactory.getShapeContainer(point3, 5);
    subGroup1.addAll(triangle2, circle1, square1);

    Circle circle2 = circleFactory.getShapeContainer(point4, 3);
    Square square2 = squareFactory.getShapeContainer(point4, 6);
    subGroup2.addAll(circle2, square2);

    return mainGroup;
  }

  @Test
  public void testMultipleGroupsXML() {
    GroupShapes groupShapes = bigTestGroup();
    Serializer xmlSerializer = MapService.getSerializer(SerializerType.XML);
    String shapeStringXML = xmlSerializer.serialize(groupShapes);

    String expectedResult = "<group><triangle><point1><x>1</x><y>1</y></point1><point2><x>2</x><y>3</y></point2><point3><x>-1</x><y>4</y></point3>" +
            "</triangle><group><triangle><point1><x>2</x><y>3</y></point1><point2><x>-1</x><y>4</y></point2><point3><x>3</x><y>-2</y></point3>" +
            "</triangle><circle><center><x>2</x><y>3</y></center><radius>5</radius></circle><square><point1><x>-1</x><y>4</y></point1><length>5</length>" +
            "</square></group><group><circle><center><x>3</x><y>-2</y></center><radius>3</radius></circle><square>" +
            "<point1><x>3</x><y>-2</y></point1><length>6</length></square></group></group>";
    assertEquals(expectedResult, shapeStringXML);
  }

  @Test
  public void testMultipleGroupsJSON() {
    GroupShapes groupShapes = bigTestGroup();
    Serializer jsonSerializer = MapService.getSerializer(SerializerType.JSON);
    String shapeStringJSON = jsonSerializer.serialize(groupShapes);
    String expectedResult = "{\"type\":\"GROUP\",\"shapesList\":[{\"type\":\"TRIANGLE\",\"point1\":{\"x\":1,\"y\":1},\"point2\":{\"x\":2,\"y\":3},\"point3\":" +
            "{\"x\":-1,\"y\":4}},{\"type\":\"GROUP\",\"shapesList\":[{\"type\":\"TRIANGLE\",\"point1\":{\"x\":2,\"y\":3},\"point2\":{\"x\":-1,\"y\":4},\"point3\":{\"x\":3,\"y\":-2}}" +
            ",{\"radius\":5,\"center\":{\"x\":2,\"y\":3},\"type\":\"CIRCLE\"},{\"type\":\"SQUARE\",\"point1\":{\"x\":-1,\"y\":4},\"length\":5}]},{\"type\":\"GROUP\",\"shapesList\":" +
            "[{\"radius\":3,\"center\":{\"x\":3,\"y\":-2},\"type\":\"CIRCLE\"},{\"type\":\"SQUARE\",\"point1\":{\"x\":3,\"y\":-2},\"length\":6}]}]}";
    assertEquals(expectedResult, shapeStringJSON);
  }

  @Test
  public void testCircleSerializationJSON() {

    Circle circle = new Circle(new Point(1, 2), 5);
    Serializer jsonSerializer = MapService.getSerializer(SerializerType.JSON);

    String shapeStringJSON = jsonSerializer.serialize(circle);
    String expectedResult = "{\"radius\":5,\"center\":{\"x\":1,\"y\":2},\"type\":\"CIRCLE\"}";
    assertEquals(expectedResult, shapeStringJSON);

  }

  @Test
  public void testSquareSerializationJSON() {

    Square square = new Square(new Point(1, 2), 5);
    Serializer jsonSerializer = MapService.getSerializer(SerializerType.JSON);

    String shapeStringJSON = jsonSerializer.serialize(square);
    String expectedResult = "{\"type\":\"SQUARE\",\"point1\":{\"x\":1,\"y\":2},\"length\":5}";
    assertEquals(expectedResult, shapeStringJSON);

  }
}