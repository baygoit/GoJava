package Lessons1.SearchByArray;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 25.06.15
 * Time: 11:45
 * @version: 1.0
 */
public final class ArrayAlgorithms {

    public static <T extends Comparable<T>> int findDistanceBetweenMinElements(ArrayList<? extends Comparable> pArrayList, int quantityElements) {
        T temp, prevMinElem, maxElem;
        int index = 0, i = 0, distance = 0;
        int[] arrayOfIndex = new int[quantityElements];

        if (pArrayList.size() < quantityElements || quantityElements == 0) {
            System.out.println("Uncorrectable parameters. Quantity analyzed elements more than size of array");
            return -1;
        }
        if (pArrayList.isEmpty()) {
            return 0;
        } else {
            temp = (T) pArrayList.get(0);
            maxElem = temp;
            prevMinElem = null;
        }

        for (i = 0; i < pArrayList.size(); i++) {
            if (((T) pArrayList.get(i)).compareTo(temp) == -1 && (prevMinElem == null || ((T) pArrayList.get(i)).compareTo(prevMinElem) == 1)) {
                temp = ((T) pArrayList.get(i));
                arrayOfIndex[index] = i;
            }
            if (prevMinElem == null && ((T) pArrayList.get(i)).compareTo(maxElem) == 1) {
                maxElem = ((T) pArrayList.get(i));
            }

            if (i == pArrayList.size() - 1) {
                prevMinElem = temp;
                temp = maxElem;
                i = -1;
                index++;
                if (index > arrayOfIndex.length - 1) {
                    break;
                }
            }
        }

        for (i = 0; i < arrayOfIndex.length - 1; i++) {
            distance += Math.abs(arrayOfIndex[i] - arrayOfIndex[i + 1]);
        }
        return distance;
    }

    public static <E> boolean inputElementsOfArray(ArrayList<E> arrayOfElements, int dimension, InputStream pInputStream){
        String[] tempString;
        E tempValue;
        Class type = (Class)((ParameterizedType)arrayOfElements.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Scanner inputDevice = new Scanner(pInputStream);

        System.out.println("Input array of " + dimension + " " + type + " elements.");
        tempString = inputDevice.nextLine().split(" ");

        if (tempString.length != dimension) {
            System.out.println("Input " + dimension + " elements. Operation is interrupt!");
            return false;
        }

        for (int i = 0; i < dimension; i++) {
            try {

                if (type == Integer.class) {
                    tempValue = (E)type.cast(Integer.parseInt(tempString[i]));
                } else if (type == Double.class){
                    tempValue = (E)type.cast(Double.parseDouble(tempString[i]));
                } else {
                    tempValue = (E)type.cast(Long.parseLong(tempString[i]));
                }
                arrayOfElements.add(tempValue);

            } catch (ClassCastException e) {
                System.out.println("Can't cast " + tempString[i] + " to " + type + " type");
                return false;
            }
        }
        return true;
    }


}

