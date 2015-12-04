package com.gojava6.XML;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
/**
 * Created by root on 21.11.15.
 */
public class DOMParserDemo {

    public static void main(String[] args) {

        try {

            File inputFile = new File("input.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputFile);

            document.getDocumentElement().normalize();

            System.out.println("Root element: " + document.getDocumentElement().getNodeName());

            NodeList nodeList = document.getElementsByTagName("student");
            System.out.println("------------------------------------");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {

                Node node = nodeList.item(temp);
                System.out.println("Current element: " + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;
                    System.out.println("Student roll no: " + element.getAttribute("rollno"));
                    System.out.println("Firs name: " + element.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last name: " + element.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Nickname: " + element.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Marks: " + element.getElementsByTagName("marks").item(0).getTextContent());

                    System.out.println("-----------------------------------------");
                }

            }

            NodeList nodeList1 = document.getElementsByTagName("teacher");
            System.out.println("*********************************");

            for (int temp = 0; temp < nodeList1.getLength(); temp++) {

                Node node = nodeList1.item(temp);
                System.out.println("Current element: " + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;
                    System.out.println("Teacher id: " + element.getAttribute("id"));
                    System.out.println("Lastname: " + element.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Secsion: " + element.getElementsByTagName("secsion").item(0).getTextContent());

                    System.out.println("--------------------------------------");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
