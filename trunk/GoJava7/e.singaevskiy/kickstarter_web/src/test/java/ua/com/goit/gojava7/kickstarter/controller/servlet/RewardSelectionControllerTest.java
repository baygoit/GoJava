package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.RewardDAO;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@RunWith(MockitoJUnitRunner.class)
public class RewardSelectionControllerTest {

    @Mock
    private RewardDAO rewardDAO;
    
    @Mock
    private ProjectDAO projectDAO;
    
    @Mock
    private RequestDispatcher dispatcher;  
    
    @Mock
    private HttpServletRequest req;
    
    @Mock
    private HttpServletResponse resp;
    
    @Mock
    private ServletConfig config;
    
    @InjectMocks
    private RewardSelectionController servlet;

	private String projectId;
    
    @Before
    public void setUp() throws Exception {
    	projectId = "1";
		Mockito.when(req.getParameter("id")).thenReturn(projectId);
    	Mockito.when(req.getRequestDispatcher(Mockito.anyString())).thenReturn(dispatcher);
    }

    @Test
    public void testDoGetHttpServletRequestHttpServletResponse() throws Exception {   
        ArrayList<Reward> rList = new ArrayList<>();
        rList.add(new Reward(1, 1, "q1", 11L));
        rList.add(new Reward(2, 1, "q1", 22L));
        Mockito.when(rewardDAO.getByProject(Mockito.anyInt())).thenReturn(rList);
        
        Project project = new Project();
		Mockito.when(projectDAO.get(Mockito.anyInt())).thenReturn(project);
        
        servlet.doGet(req, resp);
        Mockito.verify(req).getRequestDispatcher("view/Rewards.jsp");
        Mockito.verify(req).setAttribute("project", project);
        Mockito.verify(req).setAttribute("rewards", rList);
        Mockito.verify(dispatcher).forward(req, resp);       
    }
    
    @Test
    public void testDoGetNoRewards() throws Exception {   
        Mockito.when(rewardDAO.getByProject(Mockito.anyInt())).thenReturn(new ArrayList<>());

		Mockito.when(projectDAO.get(Mockito.anyInt())).thenReturn(new Project());
        
        servlet.doGet(req, resp);
        Mockito.verify(req).getRequestDispatcher("view/Payment.jsp?project=" + projectId);
        Mockito.verify(dispatcher).forward(req, resp);       
    }
    
    @Test
    public void testInit() throws Exception { 
    	ServletContext context = Mockito.mock(ServletContext.class);
		Mockito.when(config.getServletContext()).thenReturn(context);
    	StorageFactory storageFactory = Mockito.mock(StorageFactory.class);
		Mockito.when(context.getAttribute(ContextInitializer.STORAGE_FACTORY)).thenReturn(storageFactory);
    	
		servlet.init();      	
    	Mockito.verify(storageFactory).getProjectDAO(); 
    	Mockito.verify(storageFactory).getRewardDAO(); 
    }
}
