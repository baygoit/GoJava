package ua.goit.xmlparsertdd;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class XMLParser implements Parser {
  private TagStateMachine machine = new TagStateMachine();
  private final Map<Event, Set<Handler>> handlers;

  private XMLParser(Map<Event, Set<Handler>> handlers) {
    this.handlers = handlers;
  }
  
  @Override
  public void parse(String strArg) {
    parse(new ByteArrayInputStream(strArg.getBytes()));
  }

  @Override
  public void parse(File strArg) throws FileNotFoundException {
    parse(new FileInputStream(strArg));
  }

  @Override
  public void parse(InputStream iStreamReader) {

    try (InputStreamReader inputStreamReader = new InputStreamReader(iStreamReader)) {
      char c;
      while (inputStreamReader.ready()) {
        c = (char) inputStreamReader.read();
        machine.next(c, this);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void sendEventToHandler(Event event) {
    if (event == Event.OPEN_TAG) {
      Set<Handler> set = handlers.get(Event.OPEN_TAG);
      for (Handler handler : set) {
        handler.handle(machine.getResult());
      }
    }
  }

  public static class Builder {
    private Map<Event, Set<Handler>> handlers = new HashMap<>();

    public void onOpenTag(Handler handler) {
      if (handler != null) {
        Set<Handler> set;
        if (handlers.containsKey(Event.OPEN_TAG)) {
          set = handlers.get(Event.OPEN_TAG);
        } else {
          set = new HashSet<>();
        }
        set.add(handler);
        handlers.put(Event.OPEN_TAG, set);
      } else {
        throw new NumberFormatException();
      }
    }

    public void onTextValue(Handler handler) {
      Set<Handler> set = handlers.get(Event.TEXT_VALUE);
      set.add(handler);
      handlers.put(Event.TEXT_VALUE, set);
    }

    public void onStart(Handler handler) {
      Set<Handler> set = handlers.get(Event.START);
      set.add(handler);
      handlers.put(Event.START, set);
    }

    public void onEnd(Handler handler) {
      Set<Handler> set = handlers.get(Event.VALID_END);
      set.add(handler);
      handlers.put(Event.VALID_END, set);
    }

    public void onError(Handler handler) {
      Set<Handler> set = handlers.get(Event.INVALID_END);
      set.add(handler);
      handlers.put(Event.INVALID_END, set);
    }

    public static Builder newParserBuilder() {
      return new Builder();
    }

    public XMLParser build() {
      return new XMLParser(handlers);
    }
  }
}
