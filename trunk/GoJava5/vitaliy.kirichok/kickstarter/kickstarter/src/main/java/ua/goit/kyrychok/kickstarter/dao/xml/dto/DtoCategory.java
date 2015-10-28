package ua.goit.kyrychok.kickstarter.dao.xml.dto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "category")
public class DtoCategory {
    @XmlElement(name = "name", required = true)
    public String name;
    @XmlElementWrapper(name = "projects")
    @XmlElement(name = "project")
    public List<DtoProject> projects = new ArrayList<>();
    @XmlAttribute(name = "id", required = true)
    public String id;
}
