package stack;

import java.util.Stack;

/**
 * Created by Игорь on 09.12.2015.
 */
public class StackRealization {

    public static Stack<Integer> operations(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char[] chars = s.toCharArray();
        Integer value = -1;

        for (Character character : chars) {
            if (Character.isDigit(character)) {
                stack.push(Character.getNumericValue(character));

//                if (stack.isstack.size() < 1) {
//                    stack.push(value);
//                    return stack;
//                }

            } else if (character == '+') {
                int sum = stack.pop() + stack.pop();
                stack.push(sum);
            } else if (character == '*') {
                if (stack.isEmpty() || stack.size() < 1) {
                    stack.push(value);
                    return stack;
                }
                int multiply = stack.pop() * stack.pop();
                stack.push(multiply);
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        String s = "1+";
       // StackRealization stackRealization = new StackRealization();
        //Stack<Integer> stack = operations(s);

        operations(s).forEach(integer -> System.out.println(integer));

    }
}
