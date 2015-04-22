package ua.goit.xmlparsertdd.statemachine;

import ua.goit.xmlparsertdd.elements.TagElement;
import ua.goit.xmlparsertdd.elements.TagElementType;
import ua.goit.xmlparsertdd.exceptions.XMLNestingException;

import java.util.Deque;
import java.util.LinkedList;

public class TagStack {
  Deque<TagElement> tagStack = new LinkedList<>();
  boolean hadRootTag = false;
  boolean hadHeaderTag = false;

  boolean isStackEmpty() {
    return tagStack.isEmpty();
  }

  void push(TagElement tag) throws XMLNestingException {

    boolean headerAllowed = !hadRootTag && !hadHeaderTag;

    if (tag.getType() == TagElementType.HEADER) {
      if (headerAllowed) {
        hadHeaderTag = true;
      } else {
        throw new XMLNestingException("Error nesting header tag - " + tag);
      }
    }

    if (tag.getType() == TagElementType.OPEN
        || tag.getType() == TagElementType.SINGLE) {
      if (tagStack.size() == 0) {
        if (hadRootTag) {
          throw new XMLNestingException("More than one root - " + tag);
        } else {
          hadRootTag = true;
        }
      }
      tagStack.addLast(tag);
    }
  }

  TagElement get() {
    return tagStack.getLast();
  }

  TagElement pop() {
    return tagStack.pollLast();
  }
}
