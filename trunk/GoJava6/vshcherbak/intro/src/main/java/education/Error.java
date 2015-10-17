package education;

public class Error<T extends Number> {
    T ob;
    T arr[];
    //static T ob1;
    Error() { //T o  T[] dim
        //ob = new T();
        //arr = new T[10];
    }

   /* static T getOb() {
        return ob1;
    }*/

    public static void main(String[] args) {
        //Error<Integer> arr[] = new Error<Integer>[10];  //нарушает безопастность типов
        Error<?> array[] = new Error<?>[10];
    }

}
