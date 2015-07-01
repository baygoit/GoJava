package com.tyomsky;

import com.tyomsky.ui.Console;

/**
 * Created by tyoms_000 on 30.06.2015.
 */
public class Calculator {
    public void calculate(){
        Console console = new Console();
        Parser parser = new Parser();
        while (true){
            console.write("Enter expression or q for exit");
            String input = console.read();
            if (input.equals("q")){break;}

            if(parser.verify(input) == true){
              Expression expression = parser.parseExpression(input);
              console.write(String.valueOf(expression.getValue()));
            }else{
                console.write("Your expression does not satisfies pattern [x + y =]");
            }

        }
    }
}
