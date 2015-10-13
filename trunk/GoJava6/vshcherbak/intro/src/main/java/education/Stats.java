package education;

public class Stats<T extends Number> { //extends Number
    T[] nums;

    Stats(T[] o) {
        nums = o;
    }

    double average() {
        double sum = 0.0;
        for ( int i = 0; i < nums.length; i++ ) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

   /* boolean sameAvg(Stats<T> ob) { // argument tamplate
        if (average() == ob.average()) return true;
        return false;
    }*/
}

class BoundsDemo {
    public static void main(String[] args) {
        Integer[] inums = { 1, 2, 3, 4, 5 };
        Stats<Integer> iob = new Stats<Integer>(inums);
        double v = iob.average();
        System.out.println(v);

        Double[] dnums = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Stats<Double> dob = new Stats<Double>(dnums);
        double w = dob.average();
        System.out.println(w);

        Float[] fnums = { 1.0F, 2.0F, 3.0F, 4.0F, 5.0F };
        Stats<Float> fob = new Stats<Float>(fnums);
        double f = fob.average();
        System.out.println(f);

        /*Integer[] inums1 = {1, 2, 3, 4, 5};
        Stats<Integer> iob1 = new Stats<Integer>(inums1);
        double v1 = iob1.average();
        System.out.println(v1);*/

        //System.out.println(iob.sameAvg(iob1));
        //System.out.println(iob.sameAvg(dob));
        //System.out.println(iob.sameAvg(fob));
    }
}


//class Gen<T extends MyClass & MyInterface> {}
