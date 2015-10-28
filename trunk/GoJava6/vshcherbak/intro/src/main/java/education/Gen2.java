package education;

class Gen2<T> extends Gen<T>{
    Gen2(T o) {
        super(o);
    }

    T getOb() { //override
        System.out.println("override");
        return ob;
    }
}

class Gen3<T, V> extends Gen<T>{
    V ob2;
    Gen3(T o, V o2) {
        super(o);
        ob2 = o2;
    }
}

class NonGen2 {
    int x;

    NonGen2(int a) {
        x = a;
    }

    int getX() {
        return x;
    }
}

class Gen4<T> extends NonGen2{
    T ob;

    Gen4(T o, int a) {
        super(a);
        ob = o;
    }

    T getOb() {
        return ob;
    }
}

class HierDemo {
    public static void main(String[] args) {
        Gen<Integer> iob= new Gen<Integer>(88);
        Gen2<Integer> iob2= new Gen2<Integer>(99);

        Gen<String> strOb= new Gen<String>("one");
        Gen2<String> strOb2= new Gen2<String>("two");

        System.out.println(iob instanceof Gen<?>);
        System.out.println(iob2 instanceof Gen2<?>);
        System.out.println(iob instanceof Gen2<?>);

        Gen<Integer> overr = (Gen<Integer>) iob2; //?

    }
}

