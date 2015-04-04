package ua.goit.xmlparsertdd;

public class ParserBuilder {
  private Handler onOpenHandler;

  public void onOpen(Handler handler) {
    onOpenHandler = handler;
  }

  public Parser build() {
    return new XMLParser(onOpenHandler);
  }
}
