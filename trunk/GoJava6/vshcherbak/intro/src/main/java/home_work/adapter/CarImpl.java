package home_work.adapter;

public class CarImpl implements Car, Marker {
    private String name;
    private String color;

    public CarImpl(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getCarName() {
        return name;
    }

    @Override
    public String getCarColor() {
        return color;
    }

    @Override
    public String toString() {
        return getCarName() + " " + getCarColor();
    }
}
