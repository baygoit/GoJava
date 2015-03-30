import java.util.*;

public class DivideNumbers {

  public static void main(String[] args) {
    DivideNumbers divideNumbers = new DivideNumbers();
    divideNumbers.divideNumbers(4, 2);

  }

  public void divideNumbers(int first, int second) {
    int dividend = first;
    int divisor = second;
    int numbersAfterPoint = 10;
    boolean flag = true;
    boolean afterPoint = false;
    String resultBeforePoint = "";
    String resultAfterPoint = "";
    List<Map<String, Integer>> finalResult = new ArrayList<Map<String, Integer>>();
    while (numbersAfterPoint > 0 && dividend != 0) {
      if (flag) {
        afterPoint = (dividend <= divisor);
        flag = (!afterPoint);
      }
      Map<String, Integer> result = findMinimalDivided(dividend, divisor, afterPoint);
      dividend = result.get("remainder");
      if (afterPoint) {
        resultAfterPoint += result.get("div");
        numbersAfterPoint--;
      } else {
        resultBeforePoint += result.get("div");
      }
      finalResult.add(result);
    }
    String firstRemainder = finalResult.get(0).get("remainder").toString();

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("   " +first);
    stringBuilder.append("|");
    stringBuilder.append(second);
    stringBuilder.append("\n-" + firstRemainder + "|" + resultBeforePoint + "." + resultAfterPoint);
//    stringBuilder.append("\n");
    stringBuilder.append("");

    for (Map<String, Integer> res : finalResult) {
      stringBuilder.append("\n"  + res.get("dividend"));
      stringBuilder.append("\n-" + res.get("remainder"));
      stringBuilder.append("\n");
    }

    System.out.println(stringBuilder.toString());

  }

  private Map<String, Integer> findMinimalDivided(int dividend, int divisor, boolean afterPoint) {
    int dividendLength = Integer.toString(dividend).length();
    double minDividend = dividend / Math.pow(10, dividendLength - 1);
    int count = 1;
    while (minDividend < divisor) {
      count *= 10;
      minDividend *= count;
    }
    int div = (int) (minDividend / divisor);
    int minDivisorResult = divisor * div;

    int remainder;
    if (afterPoint) {
      remainder = dividend * count - minDivisorResult;
    } else {
      remainder = (int) (dividend - minDivisorResult * (dividend / minDividend));
    }

    //result
    Map<String, Integer> result = new HashMap<String, Integer>();
    result.put("dividend", dividend);
    result.put("remainder", remainder);
    result.put("div", div);
    result.put("minDivisorResult", minDivisorResult);
    return result;
  }


}
