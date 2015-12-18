package adapter;

import java.util.Comparator;

/**
 * Created by Игорь on 07.12.2015.
 */
public class CarClass implements Car {
    private String carName;
    private String color;

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarName() {
        return carName;
    }

    public String getColor() {
        return color;
    }

    public static Comparator<Car> CarNameComparator = new Comparator<Car>() {
        public int compare(Car o1, Car o2) {
            return o1.getCarName().compareTo(o2.getCarName());
        }
    };
}
