package kickstarter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kickstarter.domain.Comments;



import org.springframework.stereotype.Repository;

@Repository
public class CommentsDAO {

	@PersistenceContext
    protected EntityManager emf;

	@SuppressWarnings("unchecked")
	public List<Comments> findCommentsById(int id) {
		return emf.createQuery("from comments where id = '"+id+"'").getResultList();
	}
	 public void persist(Comments comment)
	    {
		 Comments newComment = emf.merge(comment);

	        emf.persist(newComment);
	    }

}
