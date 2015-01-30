package ua.com.goit.gojava2.solo307.interview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {
	
	List <Question> questions = new ArrayList<Question>();
	
	public XMLParser(String path){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(path);
			NodeList questions = document.getElementsByTagName("question");
			for(int i = 0; i < questions.getLength(); i++){
				Node q = questions.item(i);
				if(q.getNodeType() == Node.ELEMENT_NODE){
					Element question = (Element) q;
					int questionId = 0;
					try{
						questionId = Integer.parseInt(question.getAttribute("id"));
					} catch(NumberFormatException e){
						e.printStackTrace();
					}
					String questionLine = question.getAttribute("line");
					NodeList answers = question.getChildNodes();
					List <Answer> answerList = new ArrayList<Answer>();
					for(int j = 0; j < answers.getLength(); j++){
						Node a = answers.item(j);
						if(a.getNodeType() == Node.ELEMENT_NODE){
							Element answer = (Element) a;
							int answerId = 0;
							try{
								answerId = Integer.parseInt(answer.getAttribute("id"));
							} catch(NumberFormatException e){
								e.printStackTrace();
							}
							String answerLine = answer.getAttribute("line");
							boolean isRight = false;
							if(answer.getAttribute("isRight").equals("true")) isRight = true;
							else if(answer.getAttribute("isRight").equals("false")) isRight = false;
							else System.out.println("wrong isRight value in XML");
							answerList.add(new Answer(answerId, answerLine, isRight));
						}
					}
					writeData(questionLine, answerList, questionId);	
				}
			}
		} catch(ParserConfigurationException e){
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeData(String questionLine, List<Answer> answers, int questionId){
		questions.add(new Question(questionLine, answers, questionId));
	}
}	


