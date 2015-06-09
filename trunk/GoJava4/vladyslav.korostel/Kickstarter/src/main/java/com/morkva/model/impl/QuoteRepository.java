package com.morkva.model.impl;

import com.morkva.entities.Quote;
import com.morkva.model.IRepository;
import com.morkva.model.dao.DAO;
import com.morkva.model.dao.PersistException;

import java.util.*;

/**
 * Created by vladyslav on 17.05.15.
 */
public class QuoteRepository implements IRepository<Quote> {

    DAO<Quote, Integer> dao;

    public QuoteRepository(DAO<Quote, Integer> dao) {
        this.dao = dao;
    }

    @Override
    public Quote getById(int id) {
        Quote quote = null;
        try {
            quote = dao.getByPK(id);
        } catch (PersistException e) {
            e.printStackTrace();
        }
        return quote;
    }

    @Override
    public Quote add(Quote object) {
        Quote quote = null;
        try {
            quote = dao.create(object);
        } catch (PersistException e) {
            e.printStackTrace();
        }
        return quote;
    }

    @Override
    public void remove(Quote object) {
        try {
            dao.delete(object);
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Quote object) {
        try {
            dao.update(object);
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Quote> getAll() {
        List<Quote> all = null;
        try {
            all = dao.getAll();
        } catch (PersistException e) {
            e.printStackTrace();
        }
        return all;
    }
}
