package tyomsky.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class Projects {

    List<Project> data = new ArrayList<>();

    public int size() {
        return data.size();
    }

    public Project get(int index) {
        return data.get(index);
    }

    public void add(Project project) {
        data.add(project);
    }

}
