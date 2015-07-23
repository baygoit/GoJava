package Lessons1.DivitedByColumn;

import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 28.06.15
 * Time: 8:45
 * @version: 1.0
 */
public final class NumberAlgoritms {
    public static StringBuilder[] dividedByColumn(String expression){
        ArrayList<String> locArrayList;
        Number locNumber;
        StringBuilder[] locStringBuilder = new StringBuilder[2];
        locStringBuilder[0] = new StringBuilder();
        locStringBuilder[1] = new StringBuilder();

        String[] operands = expression.split("/");
        if (operands.length != 2) {
            System.out.println("Component support only 2 operands. Operation interrupt!");
            return null;
        }
        if (operands[0].contains(".") == true || operands[1].contains(".") == true ){
            locNumber = new Number<Double>(Double.parseDouble(operands[0]), Double.parseDouble(operands[1]));
        } else {
            locNumber = new Number<Long>(Long.parseLong(operands[0]), Long.parseLong(operands[1]));
        }
        if (Long.parseLong(operands[1]) == 0) {
            System.out.println("Divided by zero!");
            return null;
        }
        locStringBuilder[0].append(expression + "=");
        boolean isFinish = false;
        int formatStep = 0;
        while (isFinish != true){
            locNumber.dividedStep();
            locStringBuilder[1].append(locNumber.getDividend());
            locStringBuilder[1].append('\n');
            locStringBuilder[1].append("-" + locNumber.getTempResult());
            locStringBuilder[1].append("-------------");
            formatStep++;
            locStringBuilder[0].append(locNumber.getRoundDivider());
            if (locNumber.getRoundDivider() == 0) {
                isFinish = true;
            }
        }
        return locStringBuilder;
    }
    private static class Number <T extends java.lang.Number> {
        private T dividend, divider, tempResult = null;
        private Long roundResult;
        public Number(T pDividend, T pDivider) {
            this.dividend = pDividend;
            this.divider = pDivider;
        }
        public void dividedStep(){
//            double locDividend = (dividend.getClass() == Double.class) ? Double.parseDouble(dividend.toString()) : Long.parseLong(dividend.toString());
//            double locDivider = (divider.getClass() == Double.class) ? Double.parseDouble(divider.toString()) : Long.parseLong(divider.toString());
//            double locTempResult = 0;
            roundResult = (Long) Math.round(dividend/divider);
            if (tempResult == null) {
                locTempResult = (roundResult*locDivider) : ((Double)(roundResult*locDivider)).longValue();
                tempResult = castTypedValue(divider);
            } else {
                dividend = (T)(Long)(Long.class.cast(dividend).longValue() - Long.class.cast(tempResult).longValue());
                if ((Double)dividend == 0) {
                    return;
                }
                tempResult = (dividend.getClass() == Double.class) ? (T)(Double)(roundResult*locDivider) : (T)(Long)((Double)(roundResult*locDivider)).longValue();
                /*dividend = (T)
                        (((dividend.getClass() == Double.class) ? Double.parseDouble(dividend.toString()) : Long.parseLong(dividend.toString())) -
                        ((tempResult.getClass() == Double.class) ? Double.parseDouble(tempResult.toString()) : Long.parseLong(tempResult.toString()))) ;
            */
            }
        }

        private <N extends Double> Double castTypedValue (List typedValue){
                return (Double) typedValue;
        }
        private <N extends Integer> Integer castTypedValue (List typedValue){
            return (Integer) typedValue;
        }
        private <N extends Long> Long castTypedValue (N typedValue){
            return (Long) typedValue;
        }
        private <N extends Float> Float castTypedValue (N typedValue){
            return (Float) typedValue;
        }

        public Long getRoundDivider() {
            return roundResult;
        }                                                                                                        ring

        public T getDividend() {
            return dividend;
        }

        public T getDivider() {
            return divider;
        }

        public T getTempResult() {
            return tempResult;
        }

    }
}
