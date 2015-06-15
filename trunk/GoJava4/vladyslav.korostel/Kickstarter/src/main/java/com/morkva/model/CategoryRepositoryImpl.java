package com.morkva.model;

import com.morkva.entities.Category;
import com.morkva.model.dao.DAO;
import com.morkva.model.dao.PersistException;

import java.util.List;

/**
 * Created by koros on 15.06.2015.
 */
public class CategoryRepositoryImpl implements CategoryRepository {

    DAO<Category, Integer> categoryDao;

    public CategoryRepositoryImpl(DAO<Category, Integer> categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> getAll() {
        List<Category> list = null;
        try {
            list = categoryDao.getAll();
        } catch (PersistException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Category getById(int categoryId) {
        Category category = null;
        try {
            category = categoryDao.getByPK(categoryId);
        } catch (PersistException e) {
            e.printStackTrace();
        }
        return category;
    }
}
