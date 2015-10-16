package education;

public class GenMethDemo {

    static <T, V extends T> boolean isIn(T x, V[] y) {
        for ( int i = 0; i< y.length; i++ ) {
            if(x.equals(y[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] inums = { 1, 2, 3, 4, 5 };
        System.out.println(isIn(2, inums));
        System.out.println(isIn(7, inums));
        System.out.println();

        String str[] = {"one", "two", "three", "four", "five"};
        System.out.println(isIn("one", str));
        System.out.println(isIn("seven", str));

        //System.out.println(isIn("one", inums));
    }
}
