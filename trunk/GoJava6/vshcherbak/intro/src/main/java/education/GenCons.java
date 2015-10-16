package education;

public class GenCons {
    private double val;

    <T extends Number> GenCons(T arg) {
        val = arg.doubleValue();
    }

    void show() {
        System.out.println(val);
    }
}

class GenConsDemo {
    public static void main(String[] args) {
        GenCons test = new GenCons(100);
        GenCons another = new GenCons(42.3);

        test.show();
        another.show();
    }
}
