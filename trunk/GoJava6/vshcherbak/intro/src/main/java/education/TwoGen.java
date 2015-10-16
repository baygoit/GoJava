package education;

public class TwoGen<T, V, X> {
    T ob1;
    V ob2;
    X ob3;

    TwoGen(T obj1, V obj2, X obj3) {
        ob1 = obj1;
        ob2 = obj2;
        ob3 = obj3;
    }

    T getOb1() {  // different function name
        return ob1;
    }

    V getOb2() {
        return ob2;
    }

    X getOb3() {
        return ob3;
    }

    void showType() {
        System.out.println(ob1.getClass().getName());
        System.out.println(ob2.getClass().getName());
        System.out.println(ob3.getClass().getName());
    }
}

class SimpDemo {
    public static void main(String[] args) {
        TwoGen<Integer, String, Double> twoObj;
        twoObj = new TwoGen<Integer, String, Double>(88, "some text", 42.2);
        twoObj.showType();
        int v = twoObj.getOb1();
        String str = twoObj.getOb2();
        Double x = twoObj.getOb3();

        System.out.println(v);
        System.out.println(str);
        System.out.println(x);
    }
}
