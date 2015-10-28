package ua.goit.kyrychok.kickstarter.dao.xml.dto;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "faq")
public class DtoFaq {
    @XmlElement(name = "question", required = true)
    public String question;
    @XmlElement(name = "answer")
    public String answer;
    @XmlAttribute(name = "id", required = true)
    public String id;
}
