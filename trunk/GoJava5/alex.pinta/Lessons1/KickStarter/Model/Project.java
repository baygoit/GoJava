package Lessons1.KickStarter.Model;

import Lessons1.KickStarter.Model.ProjectElements.ProjectDescription;
import Lessons1.KickStarter.Model.ProjectElements.ProjectHistory;
import Lessons1.KickStarter.Model.ProjectElements.ProjectLink;
import Lessons1.KickStarter.Model.ProjectElements.ProjectQuestionAnswer;

import java.util.EnumMap;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 5:18
 * @version: 1.0
 */
public class Project implements StructureElement {
    public enum TypeProjectElements{
        DESCRIPTION, HISTORY, LINKS, QUESTION_ANSWER;
    }
    public EnumMap<TypeProjectElements, ProjectElement> projectElementEnumMap;
    private HashMap<Class, TypeProjectElements> internalMapping;

    public Project() {
        for (TypeProjectElements locElements : TypeProjectElements.values()){
            projectElementEnumMap.put(locElements, null);
        }
    }

    public boolean loadDataProjectElement(ProjectElement pProjectElement){
        TypeProjectElements element = internalMapping.get(pProjectElement.getClass());
        if (element == null) {
            return false;
        } else {
            projectElementEnumMap.put(element, pProjectElement);
            return true;
        }
    }

    @Override
    public boolean isProject() {
        return true;
    }

    {
        internalMapping.put(ProjectDescription.class,    TypeProjectElements.DESCRIPTION);
        internalMapping.put(ProjectHistory.class,        TypeProjectElements.HISTORY);
        internalMapping.put(ProjectLink.class,           TypeProjectElements.LINKS);
        internalMapping.put(ProjectQuestionAnswer.class, TypeProjectElements.DESCRIPTION);
    }
}
