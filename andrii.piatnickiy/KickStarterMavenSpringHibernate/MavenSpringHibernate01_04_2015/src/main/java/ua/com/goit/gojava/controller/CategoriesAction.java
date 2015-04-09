package ua.com.goit.gojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import ua.com.goit.gojava.dao.CategoriesDAO;
import ua.com.goit.gojava.model.Category;

public class CategoriesAction implements ModelDriven {

        private Category category;

        @Autowired
        private CategoriesDAO categoriesDAO;

        private List<Category> categories;

        public Object getModel() {
                return category;
        }

        public String getAll() throws Exception {
                setCategories(categoriesDAO.getCategories());
                return "success";
        }

        public List<Category> getCategories() {
                return categories;
        }

        public void setCategories(List<Category> categories) {
                this.categories = categories;
        }

}