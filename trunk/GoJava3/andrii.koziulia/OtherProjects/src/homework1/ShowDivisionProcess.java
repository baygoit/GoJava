package homework1;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShowDivisionProcess {
  private static final int MAXIMUM_NUMBERS_IN_VALUE = 19;
  private int resultPosition = 0;
  private int offset = 0;
  private StringBuilder mainBuilder = new StringBuilder();
  private StringBuilder result = new StringBuilder();
  private Map<Long, Long> resultMap = new LinkedHashMap<Long, Long>();

  public static void main(String[] args) throws IOException {
    //Examples for testing
    ShowDivisionProcess division = new ShowDivisionProcess();
    division.showDivisionProcess("120%4");
    division.showDivisionProcess("120/4");
    division.showDivisionProcess("3/8");
    division.showDivisionProcess(3, 8);
    division.showDivisionProcess(2, 3000);
    division.showDivisionProcess(2000, 3);
    division.showDivisionProcess("2.12/1.385");
    division.showDivisionProcess("3.1234, 5");
    division.showDivisionProcess("12/42");
    division.showDivisionProcess(13, 19);
    division.showDivisionProcess(3, 13);
  }

  public void showDivisionProcess(String expression) {
    String[] numbers = expression.split("/");
    long num1 = 0;
    long num2 = 0;
    long[] longNumbers = new long[2];
    try {
      longNumbers = convertNumbers(numbers[0], numbers[1]);
    } catch (Exception e) {
      System.out.println("Incorrect string");
      System.out.println();
      return;
    }
    num1 = longNumbers[0];
    num2 = longNumbers[1];
    showDivisionProcess(num1, num2);
  }

  private long[] convertNumbers(String string1, String string2) {
    ConvertedNumber num1 = convertValueToLong(string1);
    ConvertedNumber num2 = convertValueToLong(string2);
    int difference = num1.multiplier - num2.multiplier;
    if (num1.multiplier >= num2.multiplier) {
      num2.value *= Math.pow(10, Math.abs(difference));
    } else {
      num1.value *= Math.pow(10, Math.abs(difference));
    }
    return new long[]{num1.value, num2.value};
  }

  private class ConvertedNumber {
    long value;
    int multiplier = 0;
  }

  private ConvertedNumber convertValueToLong(String number) {
    if (number.length() > MAXIMUM_NUMBERS_IN_VALUE) {
      throw new IllegalArgumentException("The number indicated is too big");
    }
    ConvertedNumber convertedNumber = new ConvertedNumber();
    if (number.contains(".")) {
      String[] array = number.split("\\.");
      convertedNumber.value = Long.parseLong(array[0]);
      convertedNumber.value *= Math.pow(10, array[1].length());
      convertedNumber.value += Long.parseLong(array[1]);
      convertedNumber.multiplier = array[1].length();
    } else {
      convertedNumber.value = Long.parseLong(number);
    }
    return convertedNumber;
  }

  public void showDivisionProcess(long number1, long number2) {
    clearLocalVariables();
    result.append(number1 / number2);
    mainBuilder.append(" " + number1 + "|" + number2 + "\n");
    if (number1 % number2 == 0) {
      mainBuilder.append("-" + number1 + "|" + "\n");
      resultPosition = mainBuilder.length() - 1;
      mainBuilder.append(repeatCharNTimes(' ', String.valueOf(number1).length()) + "0");
      finaliseCalculation();
      return;
    }
    number1 = (number1 % number2) * 10;
    result.append(".");

    while (number1 % number2 != 0 && !resultMap.containsKey(number1)) {
      if (number1 < number2) {
        resultMap.put(number1, number1 / number2);
        number1 *= 10;
        result.append("0");
      } else {
        mainBuilder.append(repeatCharNTimes(' ', offset) + "-" + number2 * (number1 / number2) + "\n");
        if (resultPosition == 0) {
          mainBuilder.insert(mainBuilder.length() - 1, "|");
          resultPosition = mainBuilder.length() - 1;
        }
        mainBuilder.append(repeatCharNTimes(' ', offset) + repeatCharNTimes('-', 4) + "\n");
        if (number1 % number2 != 0) {
          mainBuilder.append(repeatCharNTimes(' ', offset + 3) + (number1 - (number2 * (number1 / number2))) * 10 + "\n");
        }
        resultMap.put(number1, number1 / number2);
        offset += 2;
        result.append(number1 / number2);
        number1 = (number1 % number2) * 10;
      }
    }
    if (number1 % number2 == 0) {
      result.append(number1 / number2);
      mainBuilder.append(repeatCharNTimes(' ', offset) + "-" + number2 * (number1 / number2) + "\n");
      mainBuilder.append(repeatCharNTimes(' ', String.valueOf(number1).length() + offset) + "0");
      finaliseCalculation();
      return;
    }
    String period = "";
    boolean periodFound = false;
    for (Map.Entry pair : resultMap.entrySet()) {
      if (number1 == (Long) pair.getKey()) {
        periodFound = true;
      }
      if (periodFound == true) {
        period += pair.getValue();
      }
    }
    result.append(")");
    String resultCopy = new String(result);
    int fractionPosition = resultCopy.indexOf('.');
    resultCopy = resultCopy.substring(fractionPosition);
    int periodPosition = resultCopy.indexOf(period);
    StringBuilder sb2 = new StringBuilder();
    sb2.append(result);
    sb2.insert(fractionPosition + periodPosition, "(");
    result = sb2;
    finaliseCalculation();
  }

  private void finaliseCalculation() {
    mainBuilder.insert(resultPosition, result);
    System.out.println(mainBuilder);
    System.out.println();
  }

  private void clearLocalVariables() {
    resultPosition = 0;
    offset = 0;
    result.setLength(0);
    resultMap.clear();
    mainBuilder.setLength(0);
  }

  private String repeatCharNTimes(char ch, int number) {
    return new String(new char[number]).replace('\0', ch);
  }
}
