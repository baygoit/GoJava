package ua.goit.adapter;

import ua.goit.managers.Serializer;
import ua.goit.model.Square;

public class SquareAdapterXML implements Serializer {
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

        xml.append("<length>"+ square.getLength() +"</length>");

        xml.append("</square>");
        return xml.toString();
    }

}
