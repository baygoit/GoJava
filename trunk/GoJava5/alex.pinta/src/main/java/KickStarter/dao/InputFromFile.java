package KickStarter.dao;

import KickStarter.model.Category;
import KickStarter.model.Project;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 02.07.15
 * Time: 7:36
 * @version: 1.0
 */
@XmlRootElement(name = "Main")
@XmlAccessorType(XmlAccessType.FIELD)
public class InputFromFile implements LoadingData{
    @XmlTransient
    private String fileName;

    private ArrayList<Category> catalogCategory = new ArrayList<>();

    @XmlJavaTypeAdapter(value = XMLAdapterForMap.class)
    private HashMap<Category, ArrayList<Project>>  mappingCategoryAndProject = new HashMap<>();

    public InputFromFile(String fileName) {
        this.fileName = fileName;
    }

    public InputFromFile() {
    }

    @Override
    public void load(){
        File XMLfile = new File(fileName);
        if (!XMLfile.exists()){
            ManualInput manualInput = new ManualInput();
            manualInput.load();
            this.mappingCategoryAndProject = (HashMap<Category, ArrayList<Project>>)manualInput.getMapping();
            this.catalogCategory = manualInput.getCategoryList();
            saveData();

        }
       JAXBContext jaxbContext = null;
        Unmarshaller jaxbUnmarshaller = null;
        InputFromFile inputFromFile = null;
        try {
            jaxbContext = JAXBContext.newInstance(InputFromFile.class);
            jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            inputFromFile = (InputFromFile) jaxbUnmarshaller.unmarshal(new File(fileName));
            this.catalogCategory = inputFromFile.getCategoryList();
            this.mappingCategoryAndProject = inputFromFile.getMapping();
            for (Map.Entry<Category, ArrayList<Project>> entryMap : mappingCategoryAndProject.entrySet()){
                if (entryMap.getValue() == null){
                    entryMap.setValue(new ArrayList<Project>());
                }
            }
        } catch (JAXBException e) {
            throw new RuntimeException("Exception, when unmarshalling Category and Projects");
        }
    }

    @Override
    public HashMap<Category, ArrayList<Project>> getMapping() {
        return mappingCategoryAndProject;
    }

    @Override
    public ArrayList<Category> getCategoryList() {
        return catalogCategory;
    }

    @Override
    public void saveData() {
        JAXBContext jaxbContext = null;
        Marshaller jaxbMarshaller = null;
        try {
            jaxbContext = JAXBContext.newInstance(InputFromFile.class);
            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (JAXBException e) {
            throw new RuntimeException("Can't create Category XML DOM", e);
        }

        try {
            jaxbMarshaller.marshal(this, new File(fileName));
            //jaxbMarshaller.marshal(this, System.out);
        } catch (JAXBException e) {
            throw new RuntimeException("Exception, when marshalling Category and Projects", e);
        }
    }
}
