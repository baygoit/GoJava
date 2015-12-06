package com.gojava6.JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by root on 23.11.15.
 */
public class JSONParserDemo {

    private static final String filePath = "jsonTestFile.json";

    public static void main(String[] args) {

        try {
            // read the json file
            FileReader fileReader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

            // get a string from json object
            String firstname = (String) jsonObject.get("firstname");
            System.out.println("Firstname: " + firstname);

            // get int from json object
            Long id = (Long) jsonObject.get("id");
            System.out.println("ID: " + id);

            //get array of languages from json object
            JSONArray languages = (JSONArray) jsonObject.get("languages");

            Iterator iterator = languages.iterator();
            while (iterator.hasNext()) {
                JSONObject innerObject = (JSONObject) iterator.next();
                System.out.println("Language: " + innerObject.get("lang") + ", level of knowledge: "
                        + innerObject.get("knowledge"));
            }

            JSONObject jobObject = (JSONObject) jsonObject.get("job");
            System.out.println("Job: " + jobObject.get("name") + ", site: " + jobObject.get("site"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
