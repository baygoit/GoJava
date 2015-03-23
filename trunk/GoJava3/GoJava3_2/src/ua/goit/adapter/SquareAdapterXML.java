package ua.goit.adapter;

import ua.goit.model.Square;

public class SquareAdapterXML {
    private Square square;

    public SquareAdapterXML(Square square) {
        this.square = square;
    }

    public String serialize() {
        StringBuilder xml = new StringBuilder();
        xml.append("<square>");

        xml.append("<point1>");
        xml.append("<x>" + square.getPoint1().x +"</x>");
        xml.append("<y>" + square.getPoint1().y + "</y>");
        xml.append("</point1>");

        /*xml.append("<point2>");
        xml.append("<x>" + square.getPoint2().x +"</x>");
        xml.append("<y>" + square.getPoint2().y + "</y>");
        xml.append("</point2>");

        xml.append("<point3>");
        xml.append("<x>" + square.getPoint3().x +"</x>");
        xml.append("<y>" + square.getPoint3().y + "</y>");
        xml.append("</point3>");

        xml.append("<point4>");
        xml.append("<x>" + square.getPoint4().x +"</x>");
        xml.append("<y>" + square.getPoint4().y + "</y>");
        xml.append("</point4>");*/

        xml.append("</square>");
        return xml.toString();
    }



}
