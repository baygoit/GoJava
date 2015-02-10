package ua.com.goit.gojava2.solo307.interview;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
	
	public XMLParser(String path) throws InterviewSimulatorException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = null;
			try{
				document = builder.parse(path);
			} catch(FileNotFoundException e){
				throw new InterviewSimulatorException("File" + path + "was not found");
			}
			NodeList questions = document.getElementsByTagName("question");
			for(int i = 0; i < questions.getLength(); i++){
				Node q = questions.item(i);
				if(q.getNodeType() == Node.ELEMENT_NODE){
					Element question = (Element) q;
					int questionId = 0;
					try{
						questionId = Integer.parseInt(question.getAttribute("id"));
					} catch(NumberFormatException e){
						System.out.println(e.getMessage());
					}
					String questionText = question.getAttribute("line");
					NodeList answers = question.getChildNodes();
					List <Answer> answerList = new ArrayList<Answer>();
					final char EMPTY = '0';
					for(int j = 0; j < answers.getLength(); j++){
						Node a = answers.item(j);
						if(a.getNodeType() == Node.ELEMENT_NODE){
							Element answer = (Element) a;
							String answerText = answer.getAttribute("line");
							boolean isCorrect = false;
							if(answer.getAttribute("isCorrect").equals("true")) isCorrect = true;
							else if(answer.getAttribute("isCorrect").equals("false")) isCorrect = false;
							else System.out.println("wrong isCorrect value in XML");
							answerList.add(new Answer(EMPTY, answerText, isCorrect));
						}
					}
					if(hasIdWithNull())throw new InterviewSimulatorException();
					Collections.shuffle(answerList);
					writeData(questionText, answerList, questionId);	
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
	
	public boolean hasIdWithNull(){
		for(Question answer: questions){
			if(answer.getId() == 0)return true;
		}
		return false;
	}
	
	public void writeData(String questionLine, List<Answer> answerList, int questionId){
		questions.add(new Question(questionLine, answerList, questionId));
	}
}	


