/**
 * Created by kossovec on 11.03.15.
 */
package konstantin.malov;

public class Exe003{

    private static StringBuilder answer = new StringBuilder();
    private static StringBuilder solProcess = new StringBuilder();
    private static final int NUMBER_AFTER_POINT = 100;
    private static final int NUMBER_FIRST = 42;
    private static final int NUMBER_SECOND = 17;
    private static boolean lessZero = false;

    public static void main(String[] args){
        System.out.println(NUMBER_FIRST + " | " + NUMBER_SECOND);
        System.out.println("    " +division(NUMBER_FIRST,NUMBER_SECOND));
        System.out.println(solProcess);

    }

    public static String division(int first, int second){
        if (second == 0){
            return "Error";
        }
        if (first < second){
            answer.append("0.(");
            lessZero = true;
        }
        int i = 0;
        int numberAfterPointCount = 0;
        while (numberAfterPointCount < NUMBER_AFTER_POINT && first !=0){

            i++;
            if (lessZero){
                numberAfterPointCount++;
            }
            if (first < second){
                if (!lessZero){
                    answer.append(".(");
                    lessZero = true;
                }
                first *= 10;
                solProcess.append(String.format("%"+i+"s"," ") + first + "\n")
                        .append(String.format("%"+i+"s"," ") + "-"+(first/second)*second + "\n");
                answer.append(first / second);
                first = first % second;
            } else{
                solProcess.append(String.format("%"+i+"s"," ") + first + "\n")
                        .append(String.format("%"+i+"s"," ") + "-"+(first/second)*second + "\n");
                answer.append(first / second);
                first = first % second;
            }
            solProcess.append(String.format("%"+i+"s"," ") +"___________"+ "\n");

        }
        return (lessZero) ? answer.append(")").toString() :answer.toString();

    }

}
