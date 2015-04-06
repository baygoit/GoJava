package ua.goit.alg.xmlparser;

public class StateMachine {

	private State state = State.INIT;
	private ParserData data = new ParserData();
	private XMLParser xmlparser;

	public void next(char c) {
		state = state.next(c, data, xmlparser);
	}

	private enum State {

		INIT {
			@Override
			public State next(char c, ParserData data, XMLParser xmlparser) {
				State result = INVALID_END;
				if (c == '<') {
					result = INIT;
				} 
				if (c == '?'){
					result = VALID;
				}
				return result;
			}
		},

		VALID {
			@Override
			public State next(char c, ParserData data,XMLParser xmlparser) {
				State result = INVALID_END;
				if (Character.isLetterOrDigit(c) || Character.isWhitespace(c))  {
					result = VALID;
				} if (c == '>'){
					result = START;	
				}
				return result;
			}
		},
		START {
			@Override
			public State next(char c, ParserData data, XMLParser xmlparser) {
				State result = INVALID_END;
				if (c == '<')  {
					result = OPEN_TAG ;	
				} else {
					result = END;
				}
				return result;
			}
		},
		OPEN_TAG {
			@Override
			public State next(char c, ParserData data, XMLParser xmlparser) {
				State result = INVALID_END;
				if (Character.isLetter(c)) {
					data.tag = data.getTag()+c;
					result = OPEN_TAG;
				}					
				if (c == ' ') {
					result = TAG_NAME;
				}
				if (c == '>'){
					xmlparser.onOpenTag(data);
					result = NODE;
				}
				return result;
			}
		},

		TAG_NAME {
			@Override
			public State next(char c, ParserData data, XMLParser xmlparser) {
				State result = INVALID_END;
				if (Character.isLetterOrDigit(c) || Character.isWhitespace(c) ){
					data.attributeName = data.getAttributeName()+c;
					result = TAG_NAME;
				}
				if (c == '='){
					result = ATTR_NAME;
				}
				if (c == '>') {
					xmlparser.onOpenTag(data);
					result = NODE;
				} 
				if (c == '/'){
					result = CLOSE_TAG;
				}
				return result;
			}
		},

		ATTR_NAME {
			@Override
			public State next(char c, ParserData data, XMLParser xmlparser) {
				State result = INVALID_END;
				if (Character.isLetterOrDigit(c)) {
					data.attributeValue = data.getAttributeValue()+c;
					result = ATTR_NAME;
				}	
				if (c == '"'){
					result = ATTR_VAL;
				}
				return result;
			} 
		},

		ATTR_VAL {
			@Override
			public State next(char c, ParserData data, XMLParser xmlparser) {
				State result = INVALID_END;
				if (c == '>') {
					result = NODE;
					data.setAttributes(data.attributeName, data.attributeValue);
					xmlparser.onOpenTag(data);
				}
				if (c == ' '){
					result = TAG_NAME;
				}
				return result;
			}
		},
		NODE {
			@Override
			public State next(char c, ParserData data, XMLParser xmlparser) {
				State result = INVALID_END;
				if (Character.isLetterOrDigit(c)||Character.isWhitespace(c)) {
					data.text = data.getText()+c;
					result = NODE;
				}
				if (c == '<'){
					result = ON_TEXT;
					xmlparser.onText(data);
				} 
				return result;
			}
		},
		ON_TEXT {
			@Override
			public State next(char c, ParserData data, XMLParser xmlparser) {
				State result = INVALID_END;
				if (c == '/') {
					result = CLOSE_TAG;
				}
				return result;
			}

		},
		CLOSE_TAG {
			@Override
			public State next(char c, ParserData data, XMLParser xmlparser) {
				State result = INVALID_END;
				if (c != '>' ) {
					result = CLOSE_TAG;
				}
				if (c == '>'){
					result = START;
				}
				xmlparser.onCloseTag(data);
				return result;
			}

		},

		END { 
			@Override
			public State next(char c, ParserData data, XMLParser xmlparser) {
				xmlparser.onEnd(data);
				return END;
			}
		},
		INVALID_END {
			@Override
			public State next(char c, ParserData data, XMLParser xmlparser) {
				xmlparser.onEnd(data);
				return INVALID_END; 
			}
		};

		public State next(char c, ParserData data, XMLParser xmlparser) {
			// TODO Auto-generated method stub
			return null;
		}
	}
}





