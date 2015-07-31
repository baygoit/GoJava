package ua.goit.kyrychok.kickstarter.dao.xml.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "data")
public class DtoRoot {
    @XmlElement(name = "welcome_message", required = true)
    public String welcomeMessage;
    @XmlElementWrapper(name = "categories")
    @XmlElement(name = "category")
    public List<DtoCategory> categories;
}
