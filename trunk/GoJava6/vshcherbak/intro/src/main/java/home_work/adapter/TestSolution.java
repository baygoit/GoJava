package home_work.adapter;

import java.util.Arrays;
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
                new Adapter(new CarImpl("BMW", "blue")),
                new Adapter(new CarImpl("BMW", "blue")),
                new Adapter(new TreeImpl("Atree", "green")),
                new Adapter(new TreeImpl("Atree", "white")),
                new Adapter(new TreeImpl("Etree", "green")),
                new Adapter(new TreeImpl("Ttree", "green")),
                new Adapter(new TreeImpl("Gtree", "green")),
                new Adapter(new TreeImpl("Atree", "green")),
                new Adapter(new CarImpl("BMW", "blue")),
                new Adapter(new TreeImpl("Btree", "green")),
                new Adapter(new CarImpl("AMW", "red")),
                new Adapter(new TreeImpl("Ctree", "brown")),
                new Adapter(new CarImpl("CMW", "yellow")));

        TestSolution testSolution = new TestSolution(comparator);
        testSolution.getSorted(objects);
        for (Adapter adapter: objects) {
            System.out.println(adapter);
        }
        //Collection.sort(objects, Adapter.comp);
    }
}
