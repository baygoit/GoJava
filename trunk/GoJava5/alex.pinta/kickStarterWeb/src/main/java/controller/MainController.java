package controller;


import dao.LoadingData;
import model.Category;
import model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alex-Laptop
 * Date: 14.09.15
 * Time: 14:37
 */

@Controller("/")
public class MainController {

    private LoadingData daoJDBC;

    @ModelAttribute(value = "project")
    public Project getProject(@RequestParam(required = false) String projectId) {
        if (projectId == null){
            return null;
        }
        return daoJDBC.getProjectByID(Integer.parseInt(projectId));

    }

    @ModelAttribute(value = "project_full")
    public Project getProject_fullInfo(@RequestParam(required = false) String projectId) {
        if (projectId == null){
            return null;
        }
        Project project = daoJDBC.getProjectByID(Integer.parseInt(projectId));
        daoJDBC.updateDemoLinkOfProject(project);
        daoJDBC.updateHistoryOfProject(project);
        daoJDBC.updateUserQuestionAnswerOfProject(project);
        daoJDBC.updateTermsOfProject(project);
        return project;

    }

    @ModelAttribute(value = "listOfProjects")
    public List<Project> getListOfProjectByCategoryID(@RequestParam(required = false) String categoryId) {
        if (categoryId == null){
            return null;
        }
        return daoJDBC.getListOfProjectByCategoryID(Integer.parseInt(categoryId));
    }

    @ModelAttribute(value = "category")
    public Category getCategoryByID(@RequestParam(required = false) String categoryId) {
        if (categoryId == null){
            return null;
        }
        return daoJDBC.getCategoryByID(Integer.parseInt(categoryId));
    }
//    public LoadingData getDaoJDBC() {
//        return daoJDBC;
//    }

    public void setDaoJDBC(LoadingData daoJDBC) {
        this.daoJDBC = daoJDBC;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ModelAndView start(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listOfCategories", daoJDBC.getCategoryList());
        modelAndView.setViewName("start");
        return modelAndView;
    }

    @RequestMapping(path = "/category", method = RequestMethod.GET)
    public ModelAndView category(@ModelAttribute("category") Category category, @ModelAttribute("listOfProjects") List<Project> projectList){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("category", category);
        modelAndView.addObject("listOfProjects", projectList);
        modelAndView.setViewName("category");
        return modelAndView;
    }

    @RequestMapping(path = {"/project", "/question"}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView project(@ModelAttribute("category") Category category, @ModelAttribute(value = "project_full") Project project, @RequestParam(required = false) String askQuestion,
                                @RequestParam(required = false) String userQuestion_SubmitCancel, @RequestParam(required = false) String userQuestion_description, @RequestParam(required = false) String userQuestion_userName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("category", category);
        modelAndView.addObject("project", project);

        if (askQuestion== null){
            modelAndView.addObject("modePrepareQuestion", Boolean.FALSE);
            if (userQuestion_SubmitCancel !=null && userQuestion_SubmitCancel.equals("Submit")){
                daoJDBC.setQuestionAnswerOfProject(project, userQuestion_description, userQuestion_userName);
            }
        } else {
            modelAndView.addObject("modePrepareQuestion", Boolean.TRUE);
        }
        modelAndView.setViewName("project");
        return modelAndView;
    }

    @RequestMapping(path = "/investation", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView invest(@ModelAttribute(value = "project_full") Project project, @RequestParam(required = false) String approve){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("project", project);
        if (approve!=null){
            modelAndView.setViewName("invest");
        } else {
            //TODO
        }
        return modelAndView;
    }

    @RequestMapping(path = "/term", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView term(@ModelAttribute("category") Category category, @ModelAttribute(value = "project_full") Project project,
                             @RequestParam(required = false) String chooseOfInvest, @RequestParam(required = false) String choice, @RequestParam(required = false) String userValue){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("project", project);

        if (chooseOfInvest.equals("InvestAgree")){
            if (choice!=null && choice.equals("userAmount")){
                daoJDBC.setInfoOfProject(project, "balancedAmount", project.getBalancedAmount() + Integer.parseInt(userValue));
            } else {
                Project.Terms term = daoJDBC.getTermByID(project.getId(), Integer.parseInt(choice));
                daoJDBC.setInfoOfProject(project, "balancedAmount", project.getBalancedAmount() + term.getPayAmount());
            }
        }
        modelAndView.setViewName("project");
        return modelAndView;
    }

}
