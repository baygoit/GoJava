package ua.com.goit.java5.dm.kickstarter.mvc;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/11/15
 * Time: 10:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class ModelAndView {

    private Object model;
    private String view;

    public ModelAndView() {
    }

    public ModelAndView(Object model, String view) {
        this.model = model;
        this.view = view;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelAndView that = (ModelAndView) o;

        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (view != null ? !view.equals(that.view) : that.view != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + (view != null ? view.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "[model class: " + model.getClass().getName() + ", view name: " + view + "]";
    }
}
