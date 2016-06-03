package kickstarter.service;

import java.util.List;

import kickstarter.dao.CommentsDAO;
import kickstarter.domain.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CommentsService")
@Transactional
public class CommentsService {

	@Autowired
	protected CommentsDAO dao;

	public void setDao(CommentsDAO dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public List<Comments> findCommentsById(int id) {
		return this.dao.findCommentsById(id);
	}

	@Transactional
	public void persist(Comments comment) {
		this.dao.persist(comment);
	}

}
