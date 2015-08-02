package goit.vh.kickstarter.dao;

import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.model.ProjectModel;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Viktor on 30.07.2015.
 */
public interface CategoryDAO {

      Map<Integer,ArrayList<ProjectModel>>  getCategories();

       void registerCategories(Map<Integer,ArrayList<ProjectModel>> categories);

      CategoryModel getCategoryByID(int id);
  //
}
