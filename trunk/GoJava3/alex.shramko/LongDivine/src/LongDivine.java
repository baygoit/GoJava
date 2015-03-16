public class LongDivine {

    public static String longDivine(int divisible, int divisor) {
        System.out.println("=================");
        System.out.println(divisible + " / " + divisor + " = ");
        System.out.println(divisible + "|" + divisor);
        StringBuilder str = new StringBuilder();
        StringBuilder indent = new StringBuilder();
        StringBuilder strAfterZero = new StringBuilder();
        int x = 0;
        while (x < 100) {
            int modulo = divisible % divisor;
            int result = divisible / divisor;
            if (result != 0) {
                System.out.println(indent.toString() + " " + divisible);
                System.out.println(indent.toString() + "-" + divisor * result);
                System.out.println(indent.toString() + "---");
                indent.append(" ");
            }
            if (x == 0)
                str.append(result);
            if (modulo == 0) {
                System.out.println(indent.toString() + " 0");
                if (x > 0)
                    strAfterZero.append(result);
                break;
            }
            if (x > 0) {
                int index = strAfterZero.indexOf(Integer.toString(result));
                if (index >= 0) {
                    strAfterZero.insert(index, "(").append(")");
                    break;
                } else
                    strAfterZero.append(result);
            }
            divisible = modulo * 10;
            x++;
        }
        str.append(".").append(strAfterZero);
        System.out.println("result:");
        System.out.println(str.toString());
        return str.toString();
    }

    public static void main(String[] args) {
        longDivine(97, 18);
        // longDivine(2, 10);
        // longDivine(3, 55);
        // longDivine(1, 3);
        // longDivine(1, 4);
        // longDivine(50, 3);
        // longDivine(1, 6);
        // longDivine(12, 42);

    }

}
