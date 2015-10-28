package ua.goit.alg.parser;



public class StateMachine {

    private static State state = State.INIT;
    private Tag data = new Tag();
    private XmlParserImpl xmlparser;

    public StateMachine(XmlParserImpl xmlparser) {
	this.xmlparser = xmlparser;
    }

    public void next(char c) {
	state = state.next(c, data, xmlparser);
    }

    public enum State {

	INIT {
	    @Override
	    public State next(char c, Tag data, XmlParserImpl xmlparser) {
		State result = INVALID_END;
		if (c == '<') {
		    result = INIT;
		} 
		if (c == '?'){
		    result = VALID;
		}
		System.out.println("INIT");
		return result;
	    }
	},

	VALID {
	    @Override
	    public State next(char c, Tag data, XmlParserImpl xmlparser) {
		State result = INVALID_END;
		if (c != '>')  {
		    result = VALID;
		} else {
		    result = START;	
		} 
		System.out.println("VALID "+ c);
		return result;
	    }
	},
	START {
	    @Override
	    public State next(char c, Tag data, XmlParserImpl xmlparser) {
		State result = INVALID_END;
		if (c == '<')  {
		    result = OPEN_TAG;	
		} if (Character.isWhitespace(c)) {
		    result = END;
		}
		System.out.println("START "+ c);
		return result;
	    }
	},
	OPEN_TAG {
	    @Override
	    public State next(char c, Tag data, XmlParserImpl xmlparser) {
		State result = INVALID_END;
		if (Character.isLetter(c)) {
		    data.tagName = data.getTag()+c;
		    result = TAG_NAME;
		}	
		if (c == '/'){
		    result = CLOSE_TAG;
		}
		System.out.println("OPEN_TAG "+ c);
		return result;
	    }
	},
	TAG_NAME {
	    @Override
	    public State next(char c, Tag data, XmlParserImpl xmlparser) {
		State result = INVALID_END;
		if (Character.isLetterOrDigit(c)) {
		    data.tagName = data.getTag()+c;
		    result = TAG_NAME;
		}					
		if (c == ' ') {
		    result = ATTR_NAME_START;
		}
		if (c == '>') {
		    xmlparser.handle(State.OPEN_TAG, data);
		    data.tagName = "";
		    result = NODE;
		}
		if (c == '/'){
		    result = CLOSE_TAG;
		}
		System.out.println("TAG_NAME "+ c);
		return result;
	    }
	},

	ATTR_NAME_START {
	    @Override
	    public State next(char c, Tag data, XmlParserImpl xmlparser) {
		State result = INVALID_END;
		if (Character.isLetter(c)) {
		    data.attributeName = data.getAttributeName()+c;
		    result = ATTR_NAME;
		}
		System.out.println("ATTR_NAME_START "+ c);
		return result;
	    }
	},

	ATTR_NAME {
	    @Override
	    public State next(char c, Tag data, XmlParserImpl xmlparser) {
		State result = INVALID_END;
		if (Character.isLetter(c)) {
		    data.attributeName = data.getAttributeName()+c;
		    result = ATTR_NAME;
		}
		if (Character.isDigit(c)){
		    data.attributeName = data.getAttributeName()+c;
		    result = ATTR_NAME;
		}
		if (c == ' ') {
		    result =  ATTR_NAME_START; 
		}
		if (c == '=') {
		    result = ATTR_VAL;
		}
		if (c == '>') {

		    xmlparser.handle(OPEN_TAG, data);
		    
		    data.attributeName = "";
		    data.attributeValue = "";
		    data.tagName = "";

		    result = NODE;
		} 
		if (c == '/'){
		    result = CLOSE_TAG;
		}
		System.out.println("ATTR_NAME "+ c);
		return result;
	    }
	},

	ATTR_VAL {
	    @Override
	    public State next(char c, Tag data, XmlParserImpl xmlparser) {
		State result = INVALID_END;
		if (Character.isLetterOrDigit(c)) {
		    data.setAttributeValue(data.getAttributeValue()+c);
		    result = ATTR_VAL;
		}	
		if (c == '"'){
		    result = ATTR_VAL_QUOTES;
		}

		data.setAttributes(data.getAttributeName(),data.getAttributeValue());
		System.out.println("ATTR_VAL "+ c);

		if (c == '>') {

		    xmlparser.handle(OPEN_TAG, data);

		    data.attributeValue = "";
		    data.attributeName = "";
		    data.tagName = "";
		    data.attribData.clear();

		    result = NODE;
		} 
		return result;
	    } 
	},
	ATTR_VAL_QUOTES {
	    public State next(char c, Tag data, XmlParserImpl xmlparser) {
		State result = INVALID_END;
		if (Character.isLetterOrDigit(c) || Character.isWhitespace(c) ) {
		    data.setAttributeValue(data.getAttributeValue()+c);
		    result = ATTR_VAL_QUOTES;
		}
		if (c == '"') {
		    data.setAttributeValue(data.getAttributeValue()+c);
		    result = ATTR_NAME;
		}

		return result;
	    }
	},


	NODE {
	    @Override
	    public State next(char c, Tag data, XmlParserImpl xmlparser) {
		State result = INVALID_END;
		if (Character.isLetterOrDigit(c)||Character.isWhitespace(c)) {
		    data.text = data.getText()+c;
		    result = ON_TEXT;
		}
		if (c == '<'){
		    result = TAG_NAME;

		    xmlparser.handle(State.ON_TEXT, data);
		    
		    data.text = "";
		} 
		System.out.println("NODE "+ c);
		return result;
	    }
	},
	ON_TEXT {
	    @Override
	    public State next(char c, Tag data, XmlParserImpl xmlparser) {
		State result = INVALID_END;
		if (Character.isLetterOrDigit(c)||Character.isWhitespace(c)) {
		    data.text = data.getText()+c;
		    result = ON_TEXT;
		}

		if (c == '<'){

		    xmlparser.handle(State.ON_TEXT, data);
		    
		    data.text = "";
		    result = TAG_NAME;
		} 
		System.out.println("ON_TEXT "+ c);
		return result;
	    }

	},

	CLOSE_TAG {
	    @Override
	    public State next(char c, Tag data, XmlParserImpl xmlparser) {
		State result = INVALID_END;
		if (c != '>' ) {
		    result = CLOSE_TAG;
		}
		if (c == '>') {
		    result = START;
		    
		    xmlparser.handle(State.CLOSE_TAG, data);
		}

		System.out.println("CLOSE_TAG");
		return result;
	    }

	},

	END { 
	    @Override
	    public State next(char c, Tag data, XmlParserImpl xmlparser) {
		xmlparser.handle(State.END, data);
		System.out.println("END "+ c);
		return END;
	    }
	},
	INVALID_END {

	    @Override
	    public State next(char c, Tag data, XmlParserImpl xmlparser) {
		xmlparser.handle(State.INVALID_END, data);
		System.out.println("INVALID_END "+ c);
		return INVALID_END; 
	    }
	};



	public abstract State next(char c, Tag data, XmlParserImpl xmlparser); 
    }
}






