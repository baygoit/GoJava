package com.airbnb.dao.jpa;

import com.airbnb.dao.IAdmin;
import com.airbnb.model.Admin;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Игорь on 19.11.2015.
 */
@Component
public class AdminDAO implements IAdmin {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<Admin> getAllAdmins() {
        List<Admin> admins = em.createQuery("select a from Admin a", Admin.class).getResultList();
        return admins;
    }

    @Override
    @Transactional
    public Admin getAdminById(int id) {
        Admin admin = em.find(Admin.class, id);
        return admin;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Admin admin = em.find(Admin.class, id);
        em.remove(admin);
    }

    @Override
    @Transactional
    public void addToDb(Admin admin) {
        em.persist(admin);
    }
}
