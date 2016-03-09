package ua.dborisenko.kickstarter;

public class ViewCategory extends View {
    private Category category;

    public ViewCategory(Category currentCategory) {
        category = currentCategory;
    }

    @Override
    public void generate() {
        addContentString(headerBlock);
        addContentString("Category: " + category.getName());
        addContentString("Projects:");
        addContentString(solidLine);
        Project project = new Project();
        for (int i = 0; i < category.getProjects().size(); i++) {
            project = category.getProjects().get(i);
            addContentString(((i + 1) + ": " + project.getName() + " (collected: 1" + project.getCollectedSum() + "/"
                    + project.getRequiredSum() + ")"));
            addContentString(project.getDescription());
        }
        addContentString(solidLine);
        addContentString("Enter project number or select \"0\" to return:");
        ioHandler.write(content.toString());
    }
}
