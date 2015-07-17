package Lessons1.SearchByArray;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 27.06.15
 * Time: 15:44
 * @version: 1.0
 */
public final class ArrayBuilder {
    public static IntegerArrayList getIntegerArrayGenericType(){
        return new IntegerArrayList();
    }

    public static DoubleArrayList getDoubleArrayGenericType(){
        return new DoubleArrayList();
    }

    public static LongArrayList getLongArrayGenericType(){
        return new LongArrayList();
    }

    private static class IntegerArrayList extends ArrayList<Integer> {

    }
    private static class DoubleArrayList extends ArrayList<Double> {

    }
    private static class LongArrayList extends ArrayList<Long> {

    }


}
