package com.gojava6.persistence.transactional;


import com.gojava6.persistence.lesson3.CD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CDService {

  @PersistenceContext
  private EntityManager em;

  @Transactional
  public CD createCD(CD cd) {
    em.persist(cd);
    return cd;
  }

  @Transactional
  public void removeCD(Long id) {
    CD cd = em.find(CD.class, id);
    if (cd != null)
      em.remove(cd);
  }

  public CD findCD(Long id) {
    return em.find(CD.class, id);
  }
}