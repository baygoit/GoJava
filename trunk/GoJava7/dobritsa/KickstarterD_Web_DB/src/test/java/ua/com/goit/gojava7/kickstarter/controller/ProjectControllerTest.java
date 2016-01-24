package ua.com.goit.gojava7.kickstarter.controller;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.servlet.ModelAndView;
import ua.com.goit.gojava7.kickstarter.dto.CategoryDto;
import ua.com.goit.gojava7.kickstarter.dto.ProjectDto;
import ua.com.goit.gojava7.kickstarter.model.Question;
import ua.com.goit.gojava7.kickstarter.model.Reward;
import ua.com.goit.gojava7.kickstarter.service.ProjectService;
import ua.com.goit.gojava7.kickstarter.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.ModelAndViewAssert.assertCompareListModelAttribute;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeValue;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringBeanAutowiringSupport.class)
public class ProjectControllerTest {

    @Mock
    private ProjectService projectService;
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ProjectController projectController;

    private static CategoryDto categoryDto;
    private static ProjectDto projectDto;
    private static List<Reward> rewards;
    private static List<Question> questions;

    @BeforeClass
    public static void setUp() {
        categoryDto = new CategoryDto();
        questions = new ArrayList<>();
        rewards = new ArrayList<>();

        projectDto = new ProjectDto();
        projectDto.setCategoryDto(categoryDto);
        projectDto.setQuestions(questions);
        projectDto.setRewards(rewards);
    }

    @Test
    public void testShowProject() {
        when(projectService.getFullProjectDto(anyLong())).thenReturn(projectDto);

        ModelAndView modelAndView = projectController.showProject(11L);

        assertViewName(modelAndView, "project");
        assertModelAttributeValue(modelAndView,  "category", categoryDto);
        assertModelAttributeValue(modelAndView,  "project", projectDto);
        assertCompareListModelAttribute(modelAndView, "questions", questions);
    }

    @Test
    public void testAddQuestion() {
        doNothing().when(questionService).createQuestion(anyObject(), anyLong());

        ModelAndView modelAndView = projectController.addQuestion(11L, "test");

        assertViewName(modelAndView, "redirect:/project");
        assertModelAttributeValue(modelAndView,  "projectId", 11L);
    }

    @Test
    public void testShowReward() {
        when(projectService.getProjectIdNameCategoryRewards(anyLong())).thenReturn(projectDto);

        ModelAndView modelAndView = projectController.showReward(11L);

        assertViewName(modelAndView, "reward");
        assertModelAttributeValue(modelAndView,  "category", categoryDto);
        assertModelAttributeValue(modelAndView,  "project", projectDto);
        assertCompareListModelAttribute(modelAndView, "rewards", rewards);
    }
}
