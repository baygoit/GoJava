package com.gojava6.airbnb;

import com.gojava6.airbnb.model.apartment.CityType;

import com.gojava6.airbnb.model.user.User;
import com.gojava6.airbnb.model.user.UserType;
import com.mysql.jdbc.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Autor Andrey Chaykin
 * @Since 09.11.2015
 */
public class Test {
    public static void main(String[] args) {
        String login = "l!og@in";
        String password = "!pass@word";


        boolean isLetterOrDigit = true;
        for (int i = 0; i < login.length(); i++) {
            if (!Character.isLetterOrDigit(login.charAt(i))) {
                isLetterOrDigit = false;
                System.out.println(login.charAt(i));
break;
            }
        }
        for (int j = 0; j < password.length(); j++) {
            if (!Character.isLetterOrDigit(password.charAt(j))) {
                isLetterOrDigit = false;
                System.out.println(password.charAt(j));
break;

            }
        }
        System.out.println(isLetterOrDigit);
        System.out.println(login.length());


        String s = null;

        if(s == null || s.isEmpty()) {
            System.out.println("s is empty");
        }

    }
}
