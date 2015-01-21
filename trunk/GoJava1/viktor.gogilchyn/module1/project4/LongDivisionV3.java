package ua.com.goit.gojava.lslayer.module1.project4;

import java.util.ArrayList;
import java.util.Scanner;

public class LongDivisionV3 {
    class DivisionContainer {
        int integralLength;
        int periodPosition;
        ArrayList<Integer> rests;
        ArrayList<Integer> results;
        ArrayList<Integer> tops;
        int totalLength;

        public DivisionContainer() {
            results = new ArrayList<Integer>();
            rests = new ArrayList<Integer>();
            tops = new ArrayList<Integer>();
        }

        public DivisionContainer(DivisionContainer source) {
            this.rests = source.rests;
            this.results = source.results;
            this.tops = source.tops;
            this.totalLength = source.totalLength;
            this.integralLength = source.integralLength;
            this.periodPosition = source.periodPosition;
        }
       
    }

    private static final int MAX_DEPTH = 100;
    private int divider;
    private int divisor;

    public LongDivisionV3(int divider, int divisor) {
        this.divider = divider;
        this.divisor = divisor;
    }

    public LongDivisionV3() {
        this.divider = 0;
        this.divisor = 0;
    }

    private String readFromConsole() {
        try {
            System.out.println("Enter two numbers, separatod by /:");
            return new Scanner(System.in).nextLine();
        } catch (Throwable e) {
            System.err.println(e.getMessage());
            return "";
        } 
    }
    
    private int changeFirstNumbers(int where, int from, int howMuch) {
        int innerWhere = where % (pow(10, intLength(where) - howMuch));
        int innerFrom = from * pow(10, intLength(where) - howMuch);
        return innerWhere + innerFrom;
    }

    private int checkRests(ArrayList<Integer> rests, Integer rest, int skipSize) {
        if (skipSize > rests.size())
            return -1;
        if (rest == 0) {
            if (rests.subList(skipSize, rests.size()).contains(rest))
                return rests.size();
        }
        return rests.subList(skipSize, rests.size()).contains(rest) ? 
                rests.subList(skipSize, rests.size()).indexOf(rest) : -1;
                    
    }

    private DivisionContainer divide(int divider, 
                                     int divisor, int depth,
                                     int level, DivisionContainer prevResult) {
        int integralLevel = 0;  //Number of integer digits
        while (divider > divisor) {
            divisor *= 10;
            integralLevel++;
        }
        if (depth > DEPTH)
            return prevResult; //Exit recursion on max level of depth
        DivisionContainer result = new DivisionContainer(prevResult);
        result.integralLength = prevResult.integralLength + integralLevel; //On first iteration sets number of integer digits
        int innerDivider = divider;
        int innerLevel = 0;
        int innerRest = 0;
        int nextDivider = 0;
        int innerResult = 0;
            innerDivider *= 10;
            innerRest = innerDivider % divisor;
            nextDivider = changeFirstNumbers(innerDivider, innerRest,
                    intLength(innerDivider) - innerLevel + 1);
            innerResult = (innerDivider / divisor);
            result.tops.add(innerDivider / pow(10, result.integralLength));
            result.periodPosition = checkRests(prevResult.rests, innerRest,
                    result.integralLength);
            result.totalLength = prevResult.totalLength + 1;
        result.rests.add(innerRest);
        result.results.add(innerResult);
        if (result.periodPosition == -1)
            return divide(nextDivider, divisor, depth + 1, 0, result);
        return result;
    }


    private int findBottomIndent(int top, int bottom, boolean leftEdge) {
        if (intLength(bottom) + 1 >= intLength(top)) {
            return intLength(top) - intLength(bottom);
        } 
        if (leftEdge && intLength(bottom) + 1 >= intLength(top)) {
            return intLength(top) - intLength(bottom) - 1;
        }
        return -1;
    }

    private int findTopIndent(int top, int bottom, boolean leftEdge) {
        if (intLength(bottom) == intLength(top) && leftEdge) {
            return 1;
        } else return 0;
    }

    private String formatResult(DivisionContainer result) {
        String returnValue = new String();
        if (result.integralLength == 0)
            returnValue += "0";
        for (int i = 0; i < result.totalLength - 1; i++) {
            if (i == result.integralLength)
                returnValue += ".";
            if (i == result.integralLength + result.periodPosition)
                returnValue += result.periodPosition == -1 ? "" : "(";
            returnValue += result.results.get(i);
        }
        if (result.periodPosition != -1 && result.periodPosition != result.rests.size() - 1)
            returnValue += ")";
        return returnValue;
    }

    private int intLength(int i) {
        return Integer.toString(i).length();
    }

    private String multiplySymbols(int quantity, String symbol) {
        if (quantity > 0) 
            return new String(new char[quantity]).replace("\0", symbol);
        else
            return "";
    }

    private int pow(int number, int power) { // only positive powers
        return (power <= 0) ? 1 : number * pow(number, power - 1);
    }

    private int printTopBottom(int top, int bottom, int indent) {
        int topIndent = findTopIndent(top, bottom, indent == 0);
        int bottomIndent = findBottomIndent(top, bottom, indent == 0);
        System.out.println(multiplySymbols(indent + topIndent, " ") + top);
        System.out.println(multiplySymbols(indent - 1 + bottomIndent, " ") + "-"
                + bottom);
        System.out.println(multiplySymbols(indent, " ")
                + multiplySymbols(intLength(top), "-"));
        return intLength(top) - intLength(top - bottom);
    }

    public void visualize() {
        if (this.divider == 0 && this.divisor == 0) {
            String [] inputValue = readFromConsole().split("[ / ]+");
            this.divider = Integer.parseInt(inputValue[0]);
            this.divisor = Integer.parseInt(inputValue[1]);
        }
        if (divider == divisor) {
            System.out.println(" " + divider + " | " + divisor);
            System.out.println("-" + divisor + " | 1");
            System.exit(0);
        }
        if (divisor == 0) {
            throw new IllegalArgumentException("Agrument 'divisor' can't be 0");
        }
        if (divider % divisor == 0) { 
            System.out.println(" " + divider + " | " + divisor);
            System.out.println("-" + divider + " | " + divider / divisor);
            System.exit(0);
        }
        DivisionContainer divisionResult = new DivisionContainer();
        divisionResult = divide(divider, divisor, 0, 0, divisionResult);
        int indent = 0;
        int i = 0;
        while (divisionResult.results.get(i) == 0)
            i++; // We don't need to visualize leading zeroes in result
                                                                                //Here comes magic!
        int top = divisionResult.tops.get(i); 
        int bottom = divisionResult.results.get(i) * divisor;
        int topSpaces = findTopIndent(intLength(top) > intLength(divider) ? top
                : divider, bottom, true);
        int bottomSpaces = findBottomIndent(intLength(top) > intLength(divider) ? top
                : divider, bottom, true);
        int topSplit = intLength(top) > intLength(divider) ? intLength(top)
                : intLength(divider) + topSpaces;
        int bottomSplit = intLength(bottom) + bottomSpaces;
        int splitCount = topSplit > bottomSplit ? topSplit : bottomSplit;
        String topSplitSpaces = multiplySymbols(
                splitCount - intLength(divider) - topSpaces, " ");
        String bottomSplitSpaces = multiplySymbols(splitCount
                - (intLength(bottom) + 1), " ");
        System.out.println(multiplySymbols(topSpaces, " ") + divider
                + topSplitSpaces + "| " + divisor);
        System.out.println(multiplySymbols(bottomSpaces, " ") + "-" + bottom
                + bottomSplitSpaces + "| " + formatResult(divisionResult));
        i++;
        indent = (bottomSpaces + 1 + intLength(bottom)) - intLength(top - bottom);
        System.out.println(multiplySymbols(topSpaces, " ") +
                           multiplySymbols(intLength(top), "-"));
        while (i < divisionResult.totalLength - 1) {
            while (divisionResult.results.get(i) == 0) {
                i++;
            }
            indent += printTopBottom(divisionResult.tops.get(i),
                    divisionResult.results.get(i) * divisor, indent);
            i++;
        }
    }
}
