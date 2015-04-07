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
  static Map<Event, Set<Handler>> handlers = new HashMap<>();
  static TagStateMachine machine = new TagStateMachine();
  private Handler onOpenHandler;

  public XMLParser(Handler handler) {
    onOpenHandler = handler;
  }

  public void startMachine(char c) {
    machine.next(c);
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
        startMachine(c);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void setEvent(Event event) {
    sendEventToHandler(event);
  }

  public static void sendEventToHandler(Event event) {
    if (event == Event.OPEN_TAG) {
      Set<Handler> set = handlers.get(Event.OPEN_TAG);
      for (Handler handler : set) {
        handler.handle(machine.getResult());
      }
    }
  }

  public void onOpenTag(Handler handler) {
    Set<Handler> set;
    if (handlers.containsKey(Event.OPEN_TAG)) {
      set = handlers.get(Event.OPEN_TAG);
    } else {
      set = new HashSet<>();
    }
    set.add(handler);
    handlers.put(Event.OPEN_TAG, set);
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
}
