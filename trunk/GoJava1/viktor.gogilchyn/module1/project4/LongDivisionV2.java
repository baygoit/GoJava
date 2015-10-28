package ua.com.goit.gojava.lslayer.module1.project4;

import java.util.ArrayList;
import java.util.Arrays;

public class LongDivisionV2 {
    class DivisionContainer {
        int totalLength;
        int integralLength;
        int fractalLength;
        int periodLength;
        ArrayList<Integer> rests;
        ArrayList<Integer> results;
        ArrayList<Integer> integralResults;

        public DivisionContainer() {
            this.rests = new ArrayList<Integer>();
            this.results = new ArrayList<Integer>();
            this.integralResults = new ArrayList<Integer>();
            // TODO Auto-generated constructor stub
        }
        
        
        public String getIntegralResult() {
            StringBuilder returnValue = new StringBuilder();
            for (Integer element : this.integralResults.subList(0,
                    this.integralLength)) {
                returnValue.append(element);
            }
            return returnValue.toString();

        }

        public String getFractalResult() {
            StringBuilder returnValue = new StringBuilder();
            for (Integer element : this.results.subList(0, this.periodLength)) {
                returnValue.append(element);
            }
            return returnValue.toString();

        }

        public String getPeriodResult() {
            StringBuilder returnValue = new StringBuilder("(");
            for (Integer element : this.results.subList(this.periodLength,
                    this.totalLength)) {
                returnValue.append(element);
            }
            returnValue.append(")");
            return returnValue.toString();
        }

        public void addResult(int value) {
            this.results.add(value);
        }

        public void addIntegral(int value) {
            this.integralResults.add(value);
        }

        public void addRest(int value) {
            this.rests.add(value);
        }

        public int getTotalLength() {
            return totalLength;
        }

        public void setTotalLength(int totalLength) {
            this.totalLength = totalLength;
        }

        public int getIntegralLength() {
            return integralLength;
        }

        public void setIntegralLength(int integralLength) {
            this.integralLength = integralLength - 1;
        }

        public int getFractalLength() {
            return fractalLength;
        }

        public void setFractalLength(int fractalLength) {
            this.fractalLength = fractalLength;
        }

        public int getPeriodLength() {
            return periodLength;
        }

        public void setPeriodLength(int periodLength) {
            this.periodLength = periodLength;
        }

        public int getRestPosition(int rest) {
            return (this.rests.contains(rest)) ? this.rests.indexOf(rest) : 0;
        }

        public void removeHedingNulls() {
            
            if ( this.integralResults.size() > 0) {
                this.integralResults.remove(0);
            }
            if  (this.results.size() > 0 ) {
                this.results.remove(0);
            }
        }
    }

    private static int inRest(int rest, int length, ArrayList<Integer> rests) {
        return (rests.contains(rest)) ? rests.indexOf(rest) : 0;
    }

    private DivisionContainer divide(int divident, int divisor) {
        DivisionContainer result = new DivisionContainer();
        long currentDivident = divident;
        long currentDivisor = divisor;
        int integralLength = 1;
        while (currentDivident / currentDivisor != 0) {
            if (currentDivident == 0) break;
            currentDivisor *= 10;
            integralLength++;
        }
        result.setIntegralLength(integralLength);
        while (integralLength > 0) {
            long currentRest = currentDivident % currentDivisor;
            currentDivident /= currentDivisor;
            result.addIntegral((int) currentDivident);
            currentDivident = 10 * currentRest;
            integralLength--;
        }
        int currentIntegralResult = Integer.parseInt(result.getIntegralResult());
        currentDivident = divident - currentIntegralResult * divisor;
        currentDivisor = divisor;
        int position = 0;
        int length = 0;
        while (position == 0 && length < 100) {
            if (currentDivident == 0) break;
            long currentRest = currentDivident % currentDivisor;
            currentDivident /= currentDivisor;
            result.addResult((int) currentDivident);
            currentDivident = 10 * currentRest;
            position = result.getRestPosition((int) currentRest);
            result.addRest((int) currentRest);
            result.setTotalLength(length++);
            result.setPeriodLength(position);
        }

        result.removeHedingNulls();
        return result;
    }

    private int intLength(int i) {
        return Integer.toString(i).length();
    }

    private String multiplySymbols(int quantity, String symbol) {
        return new String(new char[quantity]).replace("\0", symbol);
    }
    

    public void visualize() {
        int M = 49608590;
        int N = 495000;
        int i = 1; 
        int spacesBetween = (intLength(i*N) - intLength(M)) > 0 ? intLength(i*N) - intLength(M) : 0;
        System.out.println(" "+M+multiplySymbols(spacesBetween, " ")+" | "+N);
        System.out.println("-"+1*N+" | ");
        DivisionContainer result = divide(4960859, 495000);
        System.out.println(result.getIntegralResult() + " Intergal size = " + result.integralLength);
        System.out.println(result.getFractalResult()+result.getPeriodResult()+ " fractal length = " + result.totalLength +  " and period begins on " + result.periodLength + " position");
        System.out.println(result.rests);
    }
}
