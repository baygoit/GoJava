package ua.goit.kyrychok.kickstarter.dao.xml.dto;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "project")
public class DtoProject {
    @XmlElement(name = "name", required = true)
    public String name;
    @XmlElement(name = "description")
    public String shortDescription;
    @XmlElement(name = "goal", required = true)
    public int goal;
    @XmlElement(name = "balance")
    public int balance;
    @XmlElement(name = "create_date", required = true)
    public Date createDate;
    @XmlElement(name = "deadline_date", required = true)
    public Date deadlineDate;
    @XmlElement(name = "demo_link")
    public String demoLink;
    @XmlElementWrapper(name = "faqs")
    @XmlElement(name = "faq")
    public List<DtoFaq> faqs;
    @XmlElementWrapper(name = "events")
    @XmlElement(name = "event")
    public List<DtoProjectEvent> projectEvents;
    @XmlElementWrapper(name = "rewards")
    @XmlElement(name = "reward")
    public List<DtoReward> rewards;
    @XmlAttribute(name = "id", required = true)
    public String id;
}
