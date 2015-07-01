package com.tyomsky;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tyomsky.operations.Addition;

/**
 * Created by tyoms_000 on 30.06.2015.
 */
public class Parser {
    public Expression parseExpression(String input){        
    	return new Expression(1, 1, new Addition());
    }


    public boolean verify(String input){
        Pattern p = Pattern.compile("^\\s*([-+]?)(\\d+)(?:\\s*([-+*\\/])\\s*([-+]?)(\\d+))\\s*([=])+$");
        Matcher m = p.matcher(input);

        return m.matches();
    }
}
