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
import ua.com.goit.gojava7.kickstarter.dto.RewardDto;
import ua.com.goit.gojava7.kickstarter.model.Reward;
import ua.com.goit.gojava7.kickstarter.service.PaymentService;
import ua.com.goit.gojava7.kickstarter.service.ProjectService;
import ua.com.goit.gojava7.kickstarter.service.RewardService;
import ua.com.goit.gojava7.kickstarter.validator.MyValidator;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.ModelAndViewAssert.assertCompareListModelAttribute;
import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeValue;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpringBeanAutowiringSupport.class)
public class PaymentControllerTest {

    @Mock
    private MyValidator myValidator;
    @Mock
    private RewardService rewardService;
    @Mock
    private ProjectService projectService;
    @Mock
    private PaymentService paymentService;
    @InjectMocks
    private PaymentController paymentController;

    private static CategoryDto categoryDto;
    private static ProjectDto projectDto;
    private static RewardDto rewardDto;
    private static List<Reward> rewards;

    @BeforeClass
    public static void setUp() {
        rewards = new ArrayList<>();
        categoryDto = new CategoryDto();

        projectDto = new ProjectDto();
        projectDto.setCategoryDto(categoryDto);
        projectDto.setRewards(rewards);

        rewardDto = new RewardDto();
        rewardDto.setAmount(100L);
        rewardDto.setProjectDto(projectDto);
    }

    @Test
    public void testShowPaymentIfRewardExists() throws ServletException, IOException {
        when(rewardService.get(anyLong())).thenReturn(rewardDto);

        ModelAndView modelAndView = paymentController.showPayment(1L, null, null);

        assertViewName(modelAndView, "payment");
    }

    @Test
    public void testShowPaymentIfAmountIsCorrect() throws ServletException, IOException {
        when(myValidator.validateAmountOfPledge(anyObject())).thenReturn(true);
        when(projectService.getProjectIdNameCategory(anyLong())).thenReturn(projectDto);

        ModelAndView modelAndView = paymentController.showPayment(0L, 11L, "100");

        assertViewName(modelAndView, "payment");
    }

    @Test
    public void testShowPaymentIfAmountIsWrong() throws ServletException, IOException {
        when(myValidator.validateAmountOfPledge(anyObject())).thenReturn(false);
        when(projectService.getProjectIdNameCategoryRewards(anyLong())).thenReturn(projectDto);

        ModelAndView modelAndView = paymentController.showPayment(0L, 11L, "0");

        assertViewName(modelAndView, "reward");
    }


    @Test
    public void testRewardExistsIf0ReturnFalse() {
        assertFalse(paymentController.rewardExists(0L));
    }

    @Test
    public void testRewardExistsIf1ReturnTrue() {
        assertTrue(paymentController.rewardExists(1L));
    }

    @Test
    public void testPayWithReward() {
        when(rewardService.get(anyLong())).thenReturn(rewardDto);

        ModelAndView modelAndView = paymentController.payWithReward(anyLong());

        assertViewName(modelAndView, "payment");
        assertModelAttributeValue(modelAndView,  "amount", 100L);
        assertModelAttributeValue(modelAndView,  "category", categoryDto);
        assertModelAttributeValue(modelAndView,  "project", projectDto);
    }

    @Test
    public void testAmountIsValidIfMyValidatorIsTrueReturnTrue() {
        when(myValidator.validateAmountOfPledge(anyObject())).thenReturn(true);
        assertTrue(paymentController.amountIsValid(anyObject()));
    }

    @Test
    public void testAmountIsValidMyValidatorIsFalseReturnFalse() {
        when(myValidator.validateAmountOfPledge(anyObject())).thenReturn(false);
        assertFalse(paymentController.amountIsValid(anyObject()));
    }

    @Test
    public void testReturnWarning() {
        when(projectService.getProjectIdNameCategoryRewards(anyLong())).thenReturn(projectDto);

        ModelAndView modelAndView = paymentController.returnWarning(anyLong());

        assertViewName(modelAndView, "reward");
        assertModelAttributeValue(modelAndView,  "category", categoryDto);
        assertModelAttributeValue(modelAndView,  "project", projectDto);
        assertModelAttributeValue(modelAndView,  "message", "-----Wrong amount-----");
        assertCompareListModelAttribute(modelAndView, "rewards", rewards);
    }

    @Test
    public void testPayWithAmount() {
        when(projectService.getProjectIdNameCategory(anyLong())).thenReturn(projectDto);

        ModelAndView modelAndView = paymentController.payWithAmount("222", anyLong());

        assertViewName(modelAndView, "payment");
        assertModelAttributeValue(modelAndView,  "amount", 222L);
        assertModelAttributeValue(modelAndView,  "category", categoryDto);
        assertModelAttributeValue(modelAndView,  "project", projectDto);
    }

    @Test
    public void testCheckPaymentIfPaymentCreated() throws ServletException, IOException {
        when(projectService.getProjectIdNameCategory(anyLong())).thenReturn(projectDto);
        when(paymentService.createPayment(anyObject(), anyObject(), anyLong(), anyLong())).thenReturn(true);

        ModelAndView modelAndView = paymentController.checkPayment(11L, 200L, "Tom", "1111");

        assertViewName(modelAndView, "paymentOk");
        assertModelAttributeValue(modelAndView,  "amount", 200L);
        assertModelAttributeValue(modelAndView,  "category", categoryDto);
        assertModelAttributeValue(modelAndView,  "project", projectDto);
    }

    @Test
    public void testCheckPaymentIfPaymentNotCreated() throws ServletException, IOException {
        when(projectService.getProjectIdNameCategory(anyLong())).thenReturn(projectDto);
        when(paymentService.createPayment(anyObject(), anyObject(), anyLong(), anyLong())).thenReturn(false);

        ModelAndView modelAndView = paymentController.checkPayment(11L, 200L, "Tom", "1111");

        assertViewName(modelAndView, "payment");
        assertModelAttributeValue(modelAndView,  "amount", 200L);
        assertModelAttributeValue(modelAndView,  "category", categoryDto);
        assertModelAttributeValue(modelAndView,  "project", projectDto);
        assertModelAttributeValue(modelAndView,  "message", "-----Wrong data-----");
    }
}
