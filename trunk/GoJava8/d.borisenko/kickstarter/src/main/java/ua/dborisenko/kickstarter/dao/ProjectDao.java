package ua.dborisenko.kickstarter.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.dborisenko.kickstarter.domain.Investment;
import ua.dborisenko.kickstarter.domain.Project;
import ua.dborisenko.kickstarter.domain.Question;

@Repository
@Transactional
public class ProjectDao {

    @PersistenceContext
    private EntityManager em;

    public Project get(int id) {
        Project project = em.find(Project.class, id);
        if (project == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return project;
    }

    public Project getWithRewards(int id) {
        EntityGraph<?> graph = this.em.getEntityGraph("graph.Project.rewards");
        Map<String, Object> rewards = new HashMap<String, Object>();
        rewards.put("javax.persistence.fetchgraph", graph);
        Project project = em.find(Project.class, id, rewards);
        if (project == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return project;
    }

    public Project getWithQuestions(int id) {
        EntityGraph<?> graph = this.em.getEntityGraph("graph.Project.questions");
        Map<String, Object> questions = new HashMap<String, Object>();
        questions.put("javax.persistence.fetchgraph", graph);
        Project project = em.find(Project.class, id, questions);
        if (project == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return project;
    }

    public void addInvestment(Investment investment) {
        em.persist(investment);
        em.flush();
    }
    
    public void addQuestion(Question question) {
        em.persist(question);
        em.flush();
    }

}
