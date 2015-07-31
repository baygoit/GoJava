package ua.goit.kyrychok.kickstarter.dao.xml;

import org.xml.sax.SAXException;
import ua.goit.kyrychok.kickstarter.dao.xml.dto.*;
import ua.goit.kyrychok.kickstarter.model.Category;
import ua.goit.kyrychok.kickstarter.model.Faq;
import ua.goit.kyrychok.kickstarter.model.Project;
import ua.goit.kyrychok.kickstarter.model.Reward;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;

public class XmlStorage {
    private DtoRoot storage;
    private DtoConverter converter = new DtoConverter();
    private File dataFile;
    private File schemaFile;
    private JAXBContext context;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private AtomicInteger faqSequence = new AtomicInteger();

    public XmlStorage(File dataFile, File schemaFile) {
        this.dataFile = dataFile;
        this.schemaFile = schemaFile;
    }

    public String getWelcomeMessage() {
        return storage.welcomeMessage;
    }

    public List<Category> getCategories() {
        return converter.convertCategoriesToDomain(storage.categories);
    }

    public Category getCategory(int id) {
        for (DtoCategory category : storage.categories) {
            if (parseInt(category.id) == id) {
                return converter.convertToDomain(category);
            }
        }
        throw new IndexOutOfBoundsException(format("Category with id = \"%s\" not found", id));
    }

    private DtoProject getDtoProject(int id) {
        for (DtoCategory category : storage.categories) {
            for (DtoProject project : category.projects) {
                if (parseInt(project.id) == id) {
                    return project;
                }
            }
        }
        throw new IndexOutOfBoundsException(format("Project with id = \"%s\" not found", id));
    }

    public Project getProject(int id) {
        return converter.convertToDomain(getDtoProject(id));
    }

    public void addFaq(int projectId, Faq faq) {
        DtoProject dtoProject = getDtoProject(projectId);
        if (dtoProject.faqs == null) {
            dtoProject.faqs = new ArrayList<>();
        }
        faq.setId(faqSequence.getAndIncrement());
        dtoProject.faqs.add(converter.convertToDto(faq));
        marshal();
    }

    public List<Reward> getRewards(int projectId) {
        DtoProject project = getDtoProject(projectId);
        return converter.convertRewardsToDomain(project.rewards);
    }

    public void setProjectBalance(int projectId, int amount) {
        DtoProject dtoProject = getDtoProject(projectId);
        dtoProject.balance = amount;
        marshal();
    }

    public int getProjectBalance(int projectId) {
        DtoProject dtoProject = getDtoProject(projectId);
        return dtoProject.balance;
    }

    public Reward getReward(int id) {
        for (DtoCategory category : storage.categories) {
            for (DtoProject project : category.projects) {
                for (DtoReward reward : project.rewards) {
                    if (parseInt(reward.id) == id) {
                        return converter.convertToDomain(reward);
                    }
                }
            }
        }
        throw new IndexOutOfBoundsException(format("Reward with id = \"%s\" not found", id));
    }

    private class XmlDataProviderEventHandler implements ValidationEventHandler {
        private List<String> errors = new ArrayList<>();

        @Override
        public boolean handleEvent(ValidationEvent event) {
            errors.add("EVENT");
            errors.add(format("SEVERITY: %s", event.getSeverity()));
            errors.add(format("MESSAGE: %s", event.getMessage()));
            errors.add(format("LINKED EXCEPTION: %s", event.getLinkedException()));
            errors.add("LOCATOR");
            errors.add(format("    LINE NUMBER: %s", event.getLocator().getLineNumber()));
            errors.add(format("    COLUMN NUMBER: %s", event.getLocator().getColumnNumber()));
            errors.add(format("    OFFSET: %s", event.getLocator().getOffset()));
            errors.add(format("    OBJECT: %s", event.getLocator().getObject()));
            errors.add(format("    NODE: %s", event.getLocator().getNode()));
            errors.add(format("    URL: %s", event.getLocator().getURL()));
            return true;
        }

        public List<String> getErrors() {
            return errors;
        }

        public void showErrors() {
            for (String s : errors) {
                System.out.println(s);
            }
        }
    }

    public void init() {
        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(schemaFile);
            context = JAXBContext.newInstance(DtoRoot.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setSchema(schema);
            unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(schema);
            unmarshal();
            setSequencesValue();
        } catch (JAXBException | SAXException e) {
            e.printStackTrace();//TODO handle exception
        }
    }

    private void marshal() {
        XmlDataProviderEventHandler eventHandler = new XmlDataProviderEventHandler();
        try {
            marshaller.setEventHandler(eventHandler);
            marshaller.marshal(storage, dataFile);
            if (eventHandler.getErrors().size() > 0) {
                //TODO View errors and skip execution
                eventHandler.showErrors();
            }
        } catch (JAXBException e) {
            e.printStackTrace();//TODO handle exception
        }
    }

    private void unmarshal() {
        XmlDataProviderEventHandler eventHandler = new XmlDataProviderEventHandler();
        try {
            DtoRoot data;
            unmarshaller.setEventHandler(eventHandler);
            if (eventHandler.getErrors().size() > 0) {
                //TODO View errors and skip execution
                eventHandler.showErrors();
            }
            data = (DtoRoot) unmarshaller.unmarshal(dataFile);
            storage = data;
        } catch (JAXBException e) {
            e.printStackTrace();//TODO handle exception
        }
    }

    private void setSequencesValue() {
        List<Integer> ids = new ArrayList<>();
        for (DtoCategory category : storage.categories) {
            for (DtoProject project : category.projects) {
                for (DtoFaq faq : project.faqs) {
                    ids.add(parseInt(faq.id));
                }
            }
        }
        faqSequence.set(Collections.max(ids) + 1);
    }
}
