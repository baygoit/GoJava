package home_work.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TestSolution {
    MyComparator comparator;

    TestSolution(MyComparator comparator) {
        this.comparator = comparator;
    }

    public List getSorted(List objects) {
        objects.sort(comparator);
        return objects;
    }

    public static void main(String[] args) {
        MyComparator comparator = new MyComparator();
        List<Adapter> objects = Arrays.asList(
                new Adapter(new TreeImpl("Atree", "green")),
                new Adapter(new CarImpl("BMW", "blue")));
        TreeImpl tree;
        CarImpl car;
        Adapter adapter = new Adapter(new TreeImpl("Atree", "green"));
        objects.add(adapter);
        adapter = new Adapter(new CarImpl("BMW", "blue"));
        objects.add(adapter);
        tree = new TreeImpl("Btree", "green");
        car = new CarImpl("AMW", "red");
        adapter = new Adapter(tree);
        objects.add(adapter);
        adapter = new Adapter(car);
        objects.add(adapter);
        tree = new TreeImpl("Ctree", "brown");
        car = new CarImpl("CMW", "yellow");
        adapter = new Adapter(tree);
        objects.add(adapter);
        adapter = new Adapter(car);
        objects.add(adapter);
        TestSolution testSolution = new TestSolution(comparator);
        testSolution.getSorted(objects);
        //Collection.sort(objects, Adapter.comp);
    }
}
