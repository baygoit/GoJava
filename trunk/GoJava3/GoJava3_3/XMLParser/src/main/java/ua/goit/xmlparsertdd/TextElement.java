package ua.goit.xmlparsertdd;

public class TextElement implements Element {
  private String textValue;

  public TextElement(String textValue) {
    this.textValue = textValue;
  }

  @Override
  public String getValue() {
    return textValue;
  }

  static class Builder {
    private StringBuilder textValue = new StringBuilder();

    public void buildTextValue(char c) {
      textValue.append(c);
    }

    public void resetTextValue() {
      textValue = new StringBuilder();
    }

    public TextElement build() {
      return new TextElement(textValue.toString());
    }

    public static Builder newBuilder() {
      return new Builder();
    }
  }
}
