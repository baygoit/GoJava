package ua.goit.tishenko.xmlparser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EventHandler {
  Map<Event, Set<Handler>> mapEvents = new HashMap<>();

  public void sendEvent(Event event, Tag tag) {
    Set<Handler> handlers = mapEvents.get(event);
    if (handlers != null) {
      for (Handler handler : handlers) {
        handler.handle(tag);
      }
    }
  };

  public void sendEvent(Event event, String string) {
    Set<Handler> handlers = mapEvents.get(event);
    if (handlers != null) {

      for (Handler handler : handlers) {
        handler.handle(string);
      }
    }
  }

  public void addHandler(Event event, Handler handler) {
    
    Set<Handler> handlers = mapEvents.get(event);
    if (handlers == null) {
      handlers = new HashSet<Handler>();
    }
    handlers.add(handler);
    mapEvents.put(event, handlers);
    
    
    
  }

  public void onOpenTag(Handler handler) {
    addHandler(Event.OPEN_TAG, handler);
  }

  public void onCloseTag(Handler handler) {
    addHandler(Event.CLOSE_TAG, handler);
  }

  public void onTextValue(Handler handler) {
    addHandler(Event.TEXT_VALUE, handler);
  }

  public void onStart(Handler handler) {
    addHandler(Event.START, handler);
  }

  public void onEnd(Handler handler) {
    addHandler(Event.VALID_END, handler);
  }

  public void onError(Handler handler) {
    addHandler(Event.ERROR, handler);
  }

}
