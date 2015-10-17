package education;

public class NonGen {
    Object ob;

    NonGen(Object o) {
        ob = o;
    }

    Object getOb() {
        return ob;
    }

    void showType() {
        System.out.println(ob.getClass().getName());
    }
}

class NonGenDemo {
    public static void main(String[] args) {
        NonGen iOb;
        iOb = new NonGen(88);
        iOb.showType();
        int v = (Integer)iOb.getOb();
        //iOb = new Gen<Double>(42.0);
        System.out.println(v);
        System.out.println();

        NonGen strOb = new NonGen("text without generic");
        strOb.showType();
        String str = (String)strOb.getOb();
        System.out.println(str);
        iOb = strOb;
        System.out.println(iOb.getOb());
        //v = (Integer)iOb.getOb();
    }
}
