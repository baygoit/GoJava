package KickStarter.dao;

import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 26.07.15
 * Time: 15:12
 * @version: 1.0
 */
public class LoadingStrategy {
    private Wini iniFile;
    private Map<String, String> configurationMap = new HashMap<>();
    public LoadingData getDaoComponent(String fileName){
        configurationMap = readIniFile(fileName);
        String method =  configurationMap.get("METHOD");
        if (method.equalsIgnoreCase("ManualInput")){
            return new ManualInput();
        } else if (method.equalsIgnoreCase("InputFromFile")){
            return new InputFromFile((configurationMap.get("URL")));
        } else if (method.equalsIgnoreCase("InputFromJDBC")){
            return new InputFromJDBC(configurationMap.get("URL"), configurationMap.get("LOGIN"), configurationMap.get("PASSWORD"));
        } else {
            throw new RuntimeException("Incorrect source for loading: " + method);
        }
    }

    public Map<String, String> readIniFile(String fileName){
        File file = new File(fileName);
        try {
            if (!file.exists()){
                file.createNewFile();
                iniFile = new Wini(file);
                createNewIniFile(iniFile);
            } else {
                iniFile = new Wini(file);
            }
        } catch (IOException e) {
            throw new RuntimeException("UnExpected exception with operation ini file");
        }
        String methodOfLoading      = iniFile.get("LOADING", "CurrentSource", String.class);
        String pathForLoading       = iniFile.get("LOADING", "URL", String.class);
        String loginForLoading      = iniFile.get("LOADING", "LOGIN", String.class);
        String passwordForLoading   = iniFile.get("LOADING", "PASSWORD", String.class);
        configurationMap.put("METHOD", methodOfLoading);
        configurationMap.put("URL", pathForLoading);
        configurationMap.put("LOGIN", loginForLoading);
        configurationMap.put("PASSWORD", passwordForLoading);
        return configurationMap;
    }

    public  void createNewIniFile(Wini iniFile){
        iniFile.put("LOADING", "CurrentSource", "ManualInput");
        iniFile.put("LOADING", "URL", "kickstarter.xml");
        iniFile.put("LOADING", "LOGIN", "postgres");
        iniFile.put("LOADING", "PASSWORD", "");


        iniFile.putComment("Opportunity", "Yo can load data from memory (ManualInput.class) or file (InputFromFile.Class)");
        try {
            iniFile.store();
        } catch (IOException e) {
            throw new RuntimeException("Can't create ini file:" + iniFile.getFile().getAbsolutePath());
        }

    }
}
