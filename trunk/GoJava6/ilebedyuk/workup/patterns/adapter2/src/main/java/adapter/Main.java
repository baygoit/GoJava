package adapter;

import java.util.*;

import static adapter.CarClass.*;

/**
 * Created by Игорь on 12.12.2015.
 */
public class Main {
    public static void main(String[] args) {
        CarClass carClass = new CarClass();
        carClass.setCarName("Mazda");
        carClass.setColor("Red");

        CarClass carClass2 = new CarClass();
        carClass2.setCarName("Acura");
        carClass2.setColor("Red");

        TreeClass treeClass = new TreeClass();
        treeClass.setName("Oak");
        treeClass.setTreeColor("brown");

        Utils utils = new Utils();
        utils.printNameAndColor(carClass);

        CarAdapter carAdapter = new CarAdapter(treeClass);
        utils.printNameAndColor(carAdapter);

        List<Car> carList = Arrays.asList(carClass2, carClass, carAdapter );

        //Collections.sort(carList, new MyComparator());
        Collections.sort(carList, CarNameComparator);

        carList.forEach(car -> System.out.println(car.getCarName()));


    }
}
