package goit.vh.kickstarter.mvc.controller;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.mvc.model.CategoryModel;
import goit.vh.kickstarter.mvc.view.CategoryView;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryController {
    public CategoryView categoryView;

    public CategoryController(){
    }

     public void onDealingWithInput(int index){
         CategoryModel categoryModel = new CategoryModel();
         categoryModel.refreshModel(index);
         categoryView.render(categoryModel);

     }

}
