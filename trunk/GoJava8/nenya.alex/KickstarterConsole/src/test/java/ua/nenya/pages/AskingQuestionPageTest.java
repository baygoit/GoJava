package ua.nenya.pages;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import ua.nenya.pages.AskingQuestionPage;
import ua.nenya.project.Project;
import ua.nenya.util.IO;

public class AskingQuestionPageTest {

	private IO mockIo;
	private Project newSongProject;
	
	@Before
	public void init() {
		mockIo = mock(IO.class);
		
		
		newSongProject = new Project("New Song", "description of new song", 100, 10, 100);
		newSongProject.setHistory("hystory of new song");
		newSongProject.setVideo("video about new song");
		newSongProject.setQuestionAnswer("question about new song");
		
	}
	
	@Test
	public void askingQuestionPageTestNo() {
		
		when(mockIo.readConsole()).thenReturn("n").thenReturn("0");
		
		new AskingQuestionPage().askQuestion(newSongProject, mockIo);
		
		InOrder order = inOrder(mockIo);
	    order.verify(mockIo).write("Do you want to ask a question? (y/n): ");
	    order.verify(mockIo).writeln("");
	}
	
	@Test
	public void askingQuestionPageTestYes() {
		
		when(mockIo.readConsole()).thenReturn("y").thenReturn("Question???").thenReturn("0");
		
		new AskingQuestionPage().askQuestion(newSongProject, mockIo);
		
		InOrder order = inOrder(mockIo);
	    order.verify(mockIo).write("Do you want to ask a question? (y/n): ");
	    order.verify(mockIo).writeln("");
	    order.verify(mockIo).write("Enter your question: ");
	    
	}
}
