package ua.goit.adapter;

import ua.goit.managers.Serializer;
import ua.goit.model.Square;

public class SquareAdapterJSON implements Serializer {
  private Square square;

  SquareAdapterJSON(Square square) {
    this.square = square;
  }

  @Override
  public String serialize() {
    StringBuilder json = new StringBuilder();
    json.append("{rectangle:");

    json.append("{point1:");
    json.append("{x:" + square.getPoint1().x + "}");
    json.append("{y:" + square.getPoint1().y + "}");
    json.append("}");

    json.append("{length:" + square.getLength() + "}");

    json.append("}");
    return json.toString();  }
}
