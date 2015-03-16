package ua.shramko.calculator;

public class Calculator {

    private String inputExpression;
    private int result;
    private String numberFormat = "";

    public Calculator(String inputExpression) {
        this.inputExpression = inputExpression;
        calculate();
    }

    private int parseInt(String str, boolean isFirst) {
        int value;
        if (str.contains("(")) {
            String numberFormat = str.substring(str.indexOf("(") + 1,
                    str.indexOf(")")).toLowerCase();
            if (isFirst)
                this.numberFormat = numberFormat;
            str = str.substring(0, str.indexOf("("));
            if (numberFormat.toLowerCase().equals("r"))
                value = new RomanNumeral(str).toInt();
            else
                value = Integer.parseInt(str, Integer.parseInt(numberFormat));
        } else
            value = Integer.parseInt(str);

        return value;
    }

    private int operation(int var1, int var2, char operator) {
        switch (operator) {
        case '+':
            return var1 + var2;
            // case '-'
            // case '*'
            // case '/'
        default:
            throw new NumberFormatException(
                    "Can't indetify the expression operator!");
        }
    }

    public void calculate() {
        String stringValue1 = "", stringValue2 = "";
        char operator = 0;

        if (inputExpression.contains("+")) {
            int i = inputExpression.indexOf("+");
            stringValue1 = inputExpression.substring(0, i).trim();
            stringValue2 = inputExpression.substring(i + 1).trim();
            operator = inputExpression.charAt(i);

        }

        int value1 = parseInt(stringValue1, true);
        int value2 = parseInt(stringValue2, false);

        result = operation(value1, value2, operator);
    }

    public int toInt() {
        return result;
    }

    @Override
    public String toString() {
        switch (numberFormat) {
        case "":
            return Integer.toString(result);
        case "r":
            return new RomanNumeral(result).toString() + "(r)";
        default:
            return Integer.toString(result, Integer.parseInt(numberFormat))
                    .toUpperCase() + "(" + numberFormat + ")";
        }
    }

}
