package com.tyomsky.kickstarter.web.controller;

import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.domain.QuestionAndAnswer;
import com.tyomsky.kickstarter.service.ProjectService;
import com.tyomsky.kickstarter.service.QuestionAndAnswerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.mockito.ArgumentCaptor;
>>>>>>> b406adcc396a7505479ad772bb83478ed6740c5d
=======
import org.mockito.ArgumentCaptor;
>>>>>>> b406adcc396a7505479ad772bb83478ed6740c5d
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
<<<<<<< HEAD
<<<<<<< HEAD
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
=======
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
>>>>>>> b406adcc396a7505479ad772bb83478ed6740c5d
=======
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
>>>>>>> b406adcc396a7505479ad772bb83478ed6740c5d

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test-config/testContextForControllers.xml", "classpath:spring/spring-web-servlet.xml"})
@WebAppConfiguration
public class ProjectControllerTest {

    @Autowired private ProjectService projectServiceMock;
    @Autowired private QuestionAndAnswerService questionAndAnswerServiceMock;
    @Autowired private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        Mockito.reset(projectServiceMock);
        Mockito.reset(questionAndAnswerServiceMock);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void showProject_shouldAddProjectAndRelatedDataToModelAndReturnViewName() throws Exception {
        int requestedProjectId = 1;

        Category category = new Category();
        category.setId(1);
        category.setName("Games");

        Project project1 = new Project(1, "GTA 2", "GTA 2 descriprion", category);
        project1.setBalance(100);
        project1.setCost(101);
        project1.setDeadLine("01012016");
        project1.setHistory("some history");
        project1.setVideoLink("video link");

        QuestionAndAnswer questionAndAnswer1 = new QuestionAndAnswer(1, "question1", "answer1");
        QuestionAndAnswer questionAndAnswer2 = new QuestionAndAnswer(2, "question2", "answer2");
        questionAndAnswer1.setProject(project1);
        questionAndAnswer2.setProject(project1);

        when(projectServiceMock.getProjectById(requestedProjectId)).thenReturn(project1);
        when(questionAndAnswerServiceMock.getListByProject(project1)).thenReturn(Arrays.asList(questionAndAnswer1, questionAndAnswer2));

        String[] requestURIs = {"/project/"+requestedProjectId + "/", "/category/1/project/"+requestedProjectId + "/"};
        for (String requestUri : requestURIs) {
            mockMvc.perform(get(requestUri))
                    .andExpect(status().isOk())
                    .andExpect(view().name("project"))
                    .andExpect(model().attribute("project", hasProperty("id", is(project1.getId()))))
                    .andExpect(model().attribute("project", hasProperty("name", is(project1.getName()))))
                    .andExpect(model().attribute("project", hasProperty("description", is(project1.getDescription()))))
                    .andExpect(model().attribute("project", hasProperty("category", is(project1.getCategory()))))
                    .andExpect(model().attribute("project", hasProperty("balance", is(project1.getBalance()))))
                    .andExpect(model().attribute("project", hasProperty("cost", is(project1.getCost()))))
                    .andExpect(model().attribute("project", hasProperty("deadLine", is(project1.getDeadLine()))))
                    .andExpect(model().attribute("project", hasProperty("videoLink", is(project1.getVideoLink()))))
                    .andExpect(model().attribute("project", hasProperty("history", is(project1.getHistory()))))
                    .andExpect(model().attribute("questionsAndAnswers", hasSize(2)))
                    .andExpect(model().attribute("questionsAndAnswers", hasItem(
                            allOf(
                                    hasProperty("id", is(questionAndAnswer1.getId())),
                                    hasProperty("question", is(questionAndAnswer1.getQuestion())),
                                    hasProperty("answer", is(questionAndAnswer1.getAnswer())),
                                    hasProperty("project", is(questionAndAnswer1.getProject()))
                            )
                    )))
                    .andExpect(model().attribute("questionsAndAnswers", hasItem(
                            allOf(
                                    hasProperty("id", is(questionAndAnswer2.getId())),
                                    hasProperty("question", is(questionAndAnswer2.getQuestion())),
                                    hasProperty("answer", is(questionAndAnswer2.getAnswer())),
                                    hasProperty("project", is(questionAndAnswer2.getProject()))
                            )
                    )));
        }
        verify(projectServiceMock, times(requestURIs.length)).getProjectById(requestedProjectId);
        verify(questionAndAnswerServiceMock, times(requestURIs.length)).getListByProject(project1);
    }

    @Test
<<<<<<< HEAD
<<<<<<< HEAD
    public void testHandleQuestion() throws Exception {

    }
=======
=======
>>>>>>> b406adcc396a7505479ad772bb83478ed6740c5d
    public void whenAddQuestion_shouldSaveQuestionAndRedirectToRelatedProjectView() throws Exception {
        QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();
        String question = "question";
        questionAndAnswer.setQuestion(question);

        when(questionAndAnswerServiceMock.save(questionAndAnswer)).thenReturn(questionAndAnswer);

        String requestedURI = "/project/1/questions/add/?question="+question;
        mockMvc.perform(post(requestedURI))
                .andExpect(status().isMovedTemporarily())
                .andExpect(view().name("redirect:/project/1/"))
                .andExpect(redirectedUrl("/project/1/"));
        ArgumentCaptor<QuestionAndAnswer> argumentCaptor = ArgumentCaptor.forClass(QuestionAndAnswer.class);
        verify(questionAndAnswerServiceMock, times(1)).save(argumentCaptor.capture());
        assertEquals(question, argumentCaptor.getValue().getQuestion());
    }


<<<<<<< HEAD
>>>>>>> b406adcc396a7505479ad772bb83478ed6740c5d
=======
>>>>>>> b406adcc396a7505479ad772bb83478ed6740c5d
}