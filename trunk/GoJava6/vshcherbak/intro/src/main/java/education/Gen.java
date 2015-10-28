package education;

public class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }

    void showType() {
        System.out.println(ob.getClass().getName());
    }
}

class GenDemo {
    public static void main(String[] args) {
        Gen<Integer> iOb;
        iOb = new Gen<Integer>(88);//Gen<> JDK 7

        iOb.showType();
        int v = iOb.getOb();
        //iOb = new Gen<Double>(42.0);
        System.out.println(v);
        System.out.println();

        Gen<String> strOb = new Gen<String>("some text");
        strOb.showType();
        String str = strOb.getOb();
        System.out.println(str);

        //iOb = strOb;

        /*Gen raw = new Gen(new Double(42.0)); // make Object
        double d = (double) raw.getOb();
        System.out.println(d);
        strOb = raw;
        raw = iOb;*/

       /* Gen iob = new Gen(99);
        int y = (Integer) iob.getOb();*/
    }
}

