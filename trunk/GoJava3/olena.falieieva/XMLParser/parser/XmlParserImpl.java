package ua.goit.alg.parser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import ua.goit.alg.parser.StateMachine.State;

public class XmlParserImpl implements XmlParser {
    
    private Map<State, Handler> handlers = new HashMap<State, Handler>();
    private StateMachine stateMachine = new StateMachine(this);

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
	int i = 0;
	 while ((i = readFromStream.read()) != -1) {
	     stateMachine.next((char)i);
	 }
	Tag emptyTag = new Tag();
	handle(State.END, emptyTag);
    }

    public void onOpenTag(Handler handler) {
	handlers.put(State.OPEN_TAG, handler);
    }

    public void onCloseTag(Handler handler) {
	handlers.put(State.CLOSE_TAG, handler);
    }

    public void onTextValue(Handler handler) {
	handlers.put(State.ON_TEXT, handler);
    }

    public void onStart(Handler handler) {
	handlers.put(State.START, handler);
    }

    public void onEnd(Handler handler) {
	handlers.put(State.END, handler);
    }

    public void onError(Handler handler) {
	handlers.put(State.INVALID_END, handler);
    }

   
    public void handle(State state, Tag tag) {
	Handler handel = handlers.get(state);
	if (handel != null) {
	    handel.handle(tag);
	    
	}
    } 

    
}