package com.gojava6.XML;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by root on 22.11.15.
 */
public class DOMCreatorDemo {

    public static void main(String[] args) {

        try {
            // here we create document
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // here we create structure of xml doc
            // 1. Root element
            Element rootElement = document.createElement("cars");
            document.appendChild(rootElement);

            // 2. Supercars element(is a child of root ("cars"))
            Element supercarsElement = document.createElement("supercars");
            rootElement.appendChild(supercarsElement);

            // here we set attribute to supercarsElement
            Attr attr = document.createAttribute("company");
            attr.setValue("Ferrari");
            supercarsElement.setAttributeNode(attr);

            // 3. Carname element(is a child of supercarsElement)
            Element carnameElement = document.createElement("carname");

            Attr attrType = document.createAttribute("type");
            attrType.setValue("formula one");
            carnameElement.setAttributeNode(attrType);
            carnameElement.appendChild(document.createTextNode("Ferari 101"));

            supercarsElement.appendChild(carnameElement);

            Element carname1 = document.createElement("carname");

            Attr attr1 = document.createAttribute("type");
            attr1.setValue("sports");
            carname1.setAttributeNode(attr1);
            carname1.appendChild(document.createTextNode("Ferrari 202"));

            supercarsElement.appendChild(carname1);

            // here we write the content to xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult("cars.xml");

            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // to write new node from new line
            transformer.transform(domSource, streamResult);

            //output to console
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(domSource, consoleResult);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
