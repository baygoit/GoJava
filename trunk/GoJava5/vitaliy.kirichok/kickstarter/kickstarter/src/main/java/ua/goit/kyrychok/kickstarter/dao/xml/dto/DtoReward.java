package ua.goit.kyrychok.kickstarter.dao.xml.dto;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "reward")
public class DtoReward {
    @XmlElement(name = "amount", required = true)
    public int amount;
    @XmlElement(name = "description", required = true)
    public String description;
    @XmlAttribute(name = "id", required = true)
    public String id;
}
