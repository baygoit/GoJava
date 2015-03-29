import java.util.HashMap;
import java.util.Map;

public class DivideNumbers {

  public static void main(String[] args) {
    DivideNumbers divideNumbers = new DivideNumbers();
    divideNumbers.divideNumbers("");
  }

  public void divideNumbers(String expr) {
    int[] expArray = parseString(expr);
    int dividend = expArray[0];
    int divisor = expArray[1];

    divide(dividend, divisor);



  }

  private Map<String, Integer> divide(int dividend, int divisor) {
    Map<String, Integer> result = new HashMap<>();



    return result;
  }

  private int[] parseString(String expr) {
    int[] resualt = {12,42};

    return resualt;
  }

}
