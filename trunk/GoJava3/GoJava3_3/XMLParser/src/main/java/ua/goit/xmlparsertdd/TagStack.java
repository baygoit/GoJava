package ua.goit.xmlparsertdd;

import java.util.Deque;
import java.util.LinkedList;

public class TagStack {
  Deque<TagElement> tagStack = new LinkedList<>();
  boolean hadRootTag = false;

  void push(TagElement tag) throws XMLNestingException {

    if (tag.getType() == TagElementType.HEADER && hadRootTag) {
      throw new XMLNestingException("Error nesting header tag - " + tag);
    }

    if (tag.getType() == TagElementType.OPEN || tag.getType() == TagElementType.SINGLE) {
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
