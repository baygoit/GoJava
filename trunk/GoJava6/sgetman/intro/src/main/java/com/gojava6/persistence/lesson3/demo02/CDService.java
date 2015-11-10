package com.gojava6.persistence.lesson3.demo02;


import com.gojava6.persistence.lesson3.CD;

import javax.persistence.EntityManager;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CDService {

  // ======================================
  // =             Attributes             =
  // ======================================

  private EntityManager em;

  // ======================================
  // =            Constructors            =
  // ======================================

  public CDService(EntityManager em) {
    this.em = em;
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  public CD createCD(CD cd) {
    em.persist(cd);
    return cd;
  }

  public void removeCD(Long id) {
    CD cd = em.find(CD.class, id);
    if (cd != null)
      em.remove(cd);
  }

  public CD findCD(Long id) {
    return em.find(CD.class, id);
  }
}