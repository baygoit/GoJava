package ua.goit.xmlparsertdd;

public class ErrorElement extends Element {
  String errorMessage;

  ErrorElement(String message){
    errorMessage = message;
  }

  @Override
  public String getValue() {
    return errorMessage;
  }

  static class Builder {
    private String errorMessage;

    public void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
    }

    public TextElement build() {
      return new TextElement(errorMessage);
    }

    public static Builder newBuilder() {
      return new Builder();
    }
  }
}
