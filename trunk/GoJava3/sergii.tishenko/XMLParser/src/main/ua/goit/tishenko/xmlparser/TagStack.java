package ua.goit.tishenko.xmlparser;

import java.util.Deque;
import java.util.LinkedList;

public class TagStack {
  Deque<Tag> tagStack = new LinkedList<Tag>();
  boolean hadRootTag = false;

  void push(Tag tag) throws XMLNestingException {
    if (tag.getType() == TagType.HEADER && hadRootTag) {
      throw new XMLNestingException("Error nesting header tag - " + tag);
    }

    if (tag.getType() == TagType.OPEN || tag.getType() == TagType.SINGLE) {
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

  Tag get() {
    return tagStack.getLast();
  }

  Tag pop() {
    return tagStack.pollLast();
  }
}
