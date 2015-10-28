package ua.goit.xmlparsertdd.elements;

public class TextElement extends Element {
  private String textValue;

  public TextElement(String textValue) {
    this.textValue = textValue;
  }

  @Override
  public String getValue() {
    return textValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TextElement that = (TextElement) o;

    return !(textValue != null ? !textValue.equals(that.textValue) : that.textValue != null);
  }

  @Override
  public int hashCode() {
    return textValue != null ? textValue.hashCode() : 0;
  }

  @Override
  public String toString() {
    return textValue;
  }

  public static class Builder {
    private StringBuilder textValue = new StringBuilder();

    public void buildTextValue(char c) {
      textValue.append(c);
    }

    public void buildTextValue(String text) {
      textValue.append(text);
    }

    public TextElement build() {
      return new TextElement(textValue.toString());
    }

    public static Builder newBuilder() {
      return new Builder();
    }
  }
}
