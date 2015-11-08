package main;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class XmlParserImpl implements XmlParser {
  private Map<State, Handler> handlers = new HashMap<>();
  StateMachine stateMachine = new StateMachine();

  public void parse(String xml) throws IOException {
    parser(new ByteArrayInputStream(xml.getBytes()));
  }

  public void parse(File filePath) throws IOException {
    if (filePath.isFile() && filePath.exists()) {
      FileInputStream readFromFile = new FileInputStream(filePath);
      parser(readFromFile);
    }
  }

  private void parser(InputStream readFromStream) throws IOException {
    int sign = 0;
    while ((sign = readFromStream.read()) != -1) {
      // add string to State Machine
    }
    Tag emptyTag = new Tag("");
    handle(State.ON_END, emptyTag);
  }

  public void onOpenTag(Handler handler) {
    handlers.put(State.ON_OPEN_TAG, handler);
  }

  public void onCloseTag(Handler handler) {
    handlers.put(State.ON_CLOSE_TAG, handler);
  }

  public void onTextValue(Handler handler) {
    handlers.put(State.ON_TEXT_VALUE, handler);
  }

  public void onStart(Handler handler) {
    handlers.put(State.ON_START, handler);
  }

  public void onEnd(Handler handler) {
    handlers.put(State.ON_END, handler);
  }

  public void onError(Handler handler) {
    handlers.put(State.ON_ERROR, handler);
  }

  public void handle(State state, Tag tag) {
    Handler handel = handlers.get(state);
    if (handel != null) {
      handel.handle(tag);
    }
  }
}

