package ua.goit.tishenko.xmlparser;

public interface Handler {
  void handle(Tag tag);   
  void handle(String string);
}
