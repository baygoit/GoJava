import java.util.HashSet;
import java.util.Set;

public class Exe003 {
  private static Set<Integer> repeatedValue = new HashSet<Integer>();
  private static StringBuilder answer = new StringBuilder();
  private static StringBuilder solProcess = new StringBuilder();
  private static StringBuilder tab = new StringBuilder();
  private static final int NUMBER_AFTER_POINT = 100;
  private static final int NUMBER_FIRST = 12;
  private static final int NUMBER_SECOND = 42;
  private static boolean lessZero = false;
  private static int pointIndex;

  public static void main(String[] args) {
    System.out.println(NUMBER_FIRST + " | " + NUMBER_SECOND);
    System.out.println("    " + division(NUMBER_FIRST, NUMBER_SECOND));
    System.out.println(solProcess);
  }

  public static String division(int first, int second) {
    if (second == 0) {
      throw new RuntimeException("Error, divide by zero!");
    }

    int numberAfterPointCount = 0;
    while (numberAfterPointCount < NUMBER_AFTER_POINT && first != 0) {
      int tempValue;
      if (first < second) {
        if (!lessZero) {
          if (answer.length() == 0) {
            answer.append("0");
          }

          pointIndex = answer.length();
          lessZero = true;
        }

        first *= 10;
        tempValue = first / second;
        addSolProcess(first, second);
        first = first % second;
      } else {
        tempValue = first / second;
        addSolProcess(first, second);
        answer.append(tempValue);
        first = first % second;
      }

      addTab();
      if (lessZero) {
        numberAfterPointCount++;
        if (!repeatedValue.add(tempValue)) {
          return getAnswerWithBrackets(pointIndex);
        }

        answer.append(tempValue);
      }
    }

    return (pointIndex == 0) ?
            answer.toString() :
            getAnswerWithOutBrackets(pointIndex);
  }

  private static String getAnswerWithBrackets(int pointIndex) {
    return answer.substring(0, pointIndex) + ".(" +
            answer.substring(pointIndex, answer.length()) + ')';
  }

  private static String getAnswerWithOutBrackets(int pointIndex) {
    return answer.substring(0, pointIndex) + '.' +
            answer.substring(pointIndex, answer.length());
  }

  private static void addSolProcess(int first, int second) {
    solProcess.append(tab.toString() + first + "\n");
    solProcess.append(tab.toString() + "-" + (first / second) * second + "\n");
    solProcess.append(tab.toString() + "___________" + "\n");
  }

  private static void addTab() {
    tab.append("    ");
  }
}
