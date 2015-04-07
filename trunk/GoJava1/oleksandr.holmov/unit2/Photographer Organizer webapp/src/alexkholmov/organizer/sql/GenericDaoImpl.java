/**
 * 
 */
package alexkholmov.organizer.sql;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import alexkholmov.organizer.dao.GenericDaoInt;
import alexkholmov.organizer.dao.HibernateUtil;
import alexkholmov.organizer.exceptions.DaoException;

/**
 * @author SASH
 *
 */
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDaoInt<T, PK> {
    
    private Class<T> classT;
    
    public GenericDaoImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public GenericDaoImpl(Class<T> classT) {
        this.classT = classT;
    }
    
    @Override
    public void save(T object) throws DaoException {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.persist(object);
            session.getTransaction().commit();            
        } catch (HibernateException e) {
            throw new DaoException("Error in persist transaction", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public PK create(T object) throws DaoException {
        Session session = null;
        PK id = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            id = (PK) session.save(object);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException("Error in retrieve transaction", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return id;
    }

    @Override
    public T getObjectById(PK id) throws DaoException {
        Session session = null;
        T object = null;
        try {
            session = HibernateUtil.getSession();
            object = (T) session.get(classT, id);
        } catch (Exception e) {
            throw new DaoException("Error in retrieve transaction", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return object;
    }

    @Override
    public void update(T object) throws DaoException {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();            
        } catch (HibernateException e) {
            throw new DaoException("Error in update transaction", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(T object) throws DaoException {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();            
        } catch (HibernateException e) {
            throw new DaoException("Error in delete transaction", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }        
    }

    @Override
    public List<T> getAll() throws DaoException {
        Session session = null;
        List<T> list = new ArrayList<T>();
        try {
            session = HibernateUtil.getSession();
            list = session.createCriteria(classT).list();
        } catch (HibernateException e) {
            throw new DaoException("Error in all-getting transaction", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }        
        return list;
    }

}
