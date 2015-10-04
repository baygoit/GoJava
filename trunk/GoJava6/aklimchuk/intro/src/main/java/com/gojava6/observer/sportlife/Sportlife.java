package com.javarush.test.level13.lesson11.home07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sergiigetman on 9/16/15.
 */
public class Sportlife implements Subject {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private List<Client> clients = new ArrayList<Client>();

    public void register(Client o) throws IOException {
        System.out.println("Are you client or host?");
        String s = reader.readLine();
        if (validAppartanent(s)) {
            o.setClientType(clientTypeCH(s));
        } else {
            System.out.println("The argument is not valid");
            register(o);
        }
        System.out.println("Name: ");
        s = reader.readLine();
        if (isNameSurValid(s) || !s.equals("")) {
            o.setName(s);
        } else {
            System.out.println("The argument is not valid");
            register(o);
        }
        System.out.println("Surname: ");
        s = reader.readLine();
        if (isNameSurValid(s) && !s.equals("")) {
            o.setSurname(s);
        } else {
            System.out.println("The argument is not valid");
            register(o);
        }
        System.out.println("Email: ");
        s = reader.readLine();
        if (checkEmail(s) && !s.equals("")) {
            o.setEmail(s);
        } else {
            System.out.println("The argument is not valid");
            register(o);
        }
        if (o.getClientType()) {
            System.out.println("City: ");
            s = reader.readLine();
            if (!s.equals("")) {
                o.setEmail(s);
            } else {
                System.out.println("The argument is not valid");
                register(o);
            }
            System.out.println("Appartament type: ");
            s = reader.readLine();
            if (!s.equals("") && appartTypeValid(s)) {
                o.setAppartamentType(s);
            } else {
                System.out.println("The argument is not valid");
                register(o);
            }
        }
        clients.add(o);
    }

    public boolean appartTypeValid(String s) {
        if (s.equals("enum") || s.equals("place") || s.equals("room") || s.equals("apartment")) {
            return true;
        }
        return false;
    }

    public boolean clientTypeCH(String s) {
        if (s.equals("Host")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validAppartanent(String s) {
        if (s.equals("Client") || s.equals("Host")) {
            return true;
        } else {
            return false;
        }
    }

    public void remove(Client o) {
        clients.remove(o);
    }

    public void notifyAllObservers() {
        for (Observer observer : clients) {
            observer.update("Discount");
        }

    }


    public boolean isNameSurValid(String text) {
        char[] ch = text.toCharArray();
        int a;
        try {
            for (int i = 0; i < ch.length; i++) {
                a = Integer.parseInt(String.valueOf(ch[i]));
            }
            return false;
        } catch (NumberFormatException ex) {
            return true;
        }
    }

    public boolean checkEmail(String sEmail) {
        String sDomen = "[a-z][a-z[0-9]\u005F\u002E\u002D]*[a-z||0-9]";
        Pattern p = Pattern.compile(sDomen + "@" + sDomen + "\u002E" + sDomen);
        Matcher m = p.matcher(sEmail.toLowerCase());
        return m.matches();
    }

}
