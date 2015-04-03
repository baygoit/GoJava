package ua.goit.xmlparsertdd;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;


public class XMLReader {
  private Map<Event, Set<Handler>> handlers;
  TagStateMachine machine = new TagStateMachine();

  public void startMachine(char c) {
    machine.next(c);
  }

  public void parse(String strArg) {
    parse(new ByteArrayInputStream(strArg.getBytes()));
  }

  public void parse(File strArg) throws FileNotFoundException {
    parse(new FileInputStream(strArg));
  }

  public void parse(InputStream iStreamReader) {

    try (InputStreamReader inputStreamReader = new InputStreamReader(iStreamReader)){
      char c;
      while (inputStreamReader.ready()) {
        c = (char) inputStreamReader.read();
        startMachine(c);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void onOpenTag(Handler handler) {
    Set<Handler> set = handlers.get(Event.OPEN_TAG);
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
