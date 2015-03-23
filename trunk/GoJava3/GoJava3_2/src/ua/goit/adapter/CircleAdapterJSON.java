package ua.goit.adapter;

import ua.goit.managers.Serializer;
import ua.goit.model.Circle;

public class CircleAdapterJSON implements Serializer {
  private Circle circle;

  CircleAdapterJSON(Circle circle) {
    this.circle = circle;
  }

  @Override
  public String serialize() {
    return null;
  }
}
