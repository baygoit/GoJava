package ua.dborisenko.kickstarter;

public class DataSourceProjectCategory {

    public static void add(ProjectCategory projectCategory) {
        DataSource.allProjectCategories.add(projectCategory);
    }

    public static void update(ProjectCategory projectCategory) {
        for (int i = 0; i < DataSource.allProjectCategories.size(); i++) {
            if (DataSource.allProjectCategories.get(i).getId() == projectCategory.getId()) {
                DataSource.allProjectCategories.set(i, projectCategory);
            }
        }
    }

    public static void delete(ProjectCategory projectCategory) {
        for (int i = 0; i < DataSource.allProjectCategories.size(); i++) {
            if (DataSource.allProjectCategories.get(i).getId() == projectCategory.getId()) {
                DataSource.allProjectCategories.remove(i);
            }
        }
    }

    public static ProjectCategory getByName(String name) {
        for (ProjectCategory category : DataSource.allProjectCategories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        ProjectCategory category = new ProjectCategory();
        return category;
    }

    public static ProjectCategory getById(int id) {
        for (ProjectCategory category : DataSource.allProjectCategories) {
            if (category.getId() == id) {
                return category;
            }
        }
        ProjectCategory category = new ProjectCategory();
        return category;
    }
}
