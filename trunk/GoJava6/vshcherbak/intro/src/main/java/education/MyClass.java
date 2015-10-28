package education;

class MyClass<T extends Comparable> implements MinMax { //<T>
//class MyClass implements MinMax<Integer> {
    T[] vals;

    MyClass(T[] o) {
        vals = o;
    }

    public T min() {
        T v = vals[0];
        for (int i = 0; i < vals.length; i++ ) {
            if(vals[i].compareTo(v) < 0) {
                v = vals[i];
            }
        }
        return v;
    }

    public T max() {
        T v = vals[0];
        for (int i = 0; i < vals.length; i++ ) {
            if(vals[i].compareTo(v) > 0) {
                v = vals[i];
            }
        }
        return v;
    }
}

class GenIfDemo {
    public static void main(String[] args) {
        Integer inums[] = {1 ,2 ,3 ,4 ,5};
        Character chs[] = {'c', 'f', 'd', 'e', 's'};

        MyClass<Integer> iob = new MyClass<Integer>(inums);
        MyClass<Character> cob = new MyClass<Character>(chs);

        System.out.println(iob.min());
        System.out.println(iob.max());
        System.out.println(cob.min());
        System.out.println(cob.max());
    }
}