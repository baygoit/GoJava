package ua.goit.adapter;
import ua.goit.model.Triangle;

public class TriangleAdapterXML {
    private Triangle triangle;

    public TriangleAdapterXML(Triangle triangle){
        this.triangle = triangle;
    }

    public String serialize() {
        StringBuilder xml = new StringBuilder();
        xml.append("<triangle>");

        xml.append("<point1>");
        xml.append("<x>" + triangle.point1.x + "</x>");
        xml.append("<y>" + triangle.point1.y + "</y>");
        xml.append("</point1>");

        xml.append("<point2>");
        xml.append("<x>" + triangle.point2.x + "</x>");
        xml.append("<y>" + triangle.point2.y + "</y>");
        xml.append("</point2>");

        xml.append("<point3>");
        xml.append("<x>" + triangle.point3.x + "</x>");
        xml.append("<y>" + triangle.point3.y + "</y>");
        xml.append("</point3>");

        xml.append("</triangle>");

        return xml.toString();
    }


}
