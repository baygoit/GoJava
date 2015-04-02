package main.ua.goit.xmlparsertdd;

import main.ua.goit.xmlparser.Handler;
import main.ua.goit.xmlparser.State;

import java.io.*;
import java.util.Map;
import java.util.Set;

public class XMLReader {
  private Map<State, Set<Handler>> handlers;
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
    Set<Handler> set = handlers.get(State.OPEN_TAG);
    set.add(handler);
    handlers.put(State.OPEN_TAG, set);
  }

  public void onTextValue(Handler handler) {
    Set<Handler> set = handlers.get(State.TEXT_VALUE);
    set.add(handler);
    handlers.put(State.TEXT_VALUE, set);
  }

  public void onStart(Handler handler) {
    Set<Handler> set = handlers.get(State.START);
    set.add(handler);
    handlers.put(State.START, set);
  }

  public void onEnd(Handler handler) {
    Set<Handler> set = handlers.get(State.VALID_END);
    set.add(handler);
    handlers.put(State.VALID_END, set);
  }

  public void onError(Handler handler) {
    Set<Handler> set = handlers.get(State.INVALID_END);
    set.add(handler);
    handlers.put(State.INVALID_END, set);
  }
}
