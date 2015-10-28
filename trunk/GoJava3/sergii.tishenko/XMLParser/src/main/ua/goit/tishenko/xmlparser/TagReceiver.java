package ua.goit.tishenko.xmlparser;

interface TagReceiver {
  void nextTag(Tag tag) throws XMLNestingException;
}
