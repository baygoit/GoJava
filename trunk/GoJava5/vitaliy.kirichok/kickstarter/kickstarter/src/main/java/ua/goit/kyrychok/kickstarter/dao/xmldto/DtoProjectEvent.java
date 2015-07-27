package ua.goit.kyrychok.kickstarter.dao.xmldto;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "event")
public class DtoProjectEvent {
    @XmlElement(name = "event_date", required = true)
    public Date eventDate;
    @XmlElement(name = "message", required = true)
    public String message;
    @XmlAttribute(name = "id", required = true)
    public String id;
}
