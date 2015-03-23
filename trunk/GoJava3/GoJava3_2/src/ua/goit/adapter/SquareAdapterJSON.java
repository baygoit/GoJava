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
    return null;
  }
}
