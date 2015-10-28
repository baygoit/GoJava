package ua.com.goit.gojava.POM.persistence.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import ua.com.goit.gojava.POM.dataModel.common.FinancialDocument;
import ua.com.goit.gojava.POM.dataModel.profitcost.ProjectFinResultEntry;
import ua.com.goit.gojava.POM.persistence.POMPersistenceException;
import ua.com.goit.gojava.POM.persistence.hibernate.abstraction.AbstractDAO;

public class ProjectFinResultEntryDAO extends AbstractDAO<ProjectFinResultEntry> {
	
	private static final String CLASS_NAME = "Project FinResult Entry"; 
	private static final Logger LOG = Logger.getLogger(ProjectFinResultEntryDAO.class);
	
	public ProjectFinResultEntryDAO() {
		super(ProjectFinResultEntry.class);
	}
	
	@Override
	protected String getClassName() {
		
		return CLASS_NAME;
	}

	@Override
	protected Logger getLog() {
		
		return LOG;	
	}

	@Override
	protected ProjectFinResultEntry getNewObject() {

		return new ProjectFinResultEntry();	
	}

	public void deleteAllByDoc(FinancialDocument doc) throws POMPersistenceException {

		Session session = getSession();
		try {
			
			session.beginTransaction();
			String hql = "delete from ProjectFinResultEntry where doc= :doc";
			session.createQuery(hql).setParameter("doc",doc).executeUpdate();
            session.getTransaction().commit();
            
        } catch (HibernateException | NullPointerException e) {
			getLog().error("Could not delete "+getClassName()+": "+e.getMessage(), e);
			throw new POMPersistenceException("Could not delete "+getClassName()+": "+e.getMessage(), e);
		} finally {
			closeSession(session);
	    }
		
	}
}
