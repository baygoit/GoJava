package ua.com.goit.gojava2.solo307.interview;

import java.io.File;
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

	private IdGenerator idGenerator = new IdGenerator();

	public List<Question> parse(File file) throws InterviewSimulatorException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		List <Question> questionsList = new ArrayList<Question>();
		try{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(file.getAbsolutePath());
			NodeList questions = document.getElementsByTagName("question");
			for(int i = 0; i < questions.getLength(); i++){
				Node q = questions.item(i);
				if(q.getNodeType() == Node.ELEMENT_NODE){
					Element question = (Element) q;
					String questionText = question.getAttribute("line");
					NodeList answers = question.getChildNodes();
					List <Answer> answerList = new ArrayList<Answer>();
					for(int j = 0; j < answers.getLength(); j++){
						Node a = answers.item(j);
						if(a.getNodeType() == Node.ELEMENT_NODE){
							Element answer = (Element) a;
							String answerText = answer.getAttribute("line");
							boolean isCorrect = false;
							if(answer.getAttribute("isCorrect").equals("true")) isCorrect = true;
							else if(answer.getAttribute("isCorrect").equals("false")) isCorrect = false;
							else System.out.println("wrong isCorrect value in XML");
							int aId = idGenerator.getAnswerId();
							answerList.add(new Answer(aId, answerText, isCorrect));
							idGenerator.addAsnwerId();
						}
					}
					int qId = idGenerator.getQuestionId();
					questionsList.add(new Question(questionText, answerList, qId));
					idGenerator.addQuestionId();
				}
			}
		} catch(ParserConfigurationException e){
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return questionsList;
	}
}	


