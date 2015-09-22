package main;

/**
 * Created by user on 19.09.2015.
 */
public class User {
    private String name;
    private String sername;
    private String email;

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        //to test
        if (name.isEmpty()||name.equals("Null")||name.matches(".*\\d+.*")) {return false;}
        this.name = name;
        return true;
    }

    public String getSername() {
        return sername;
    }

    public boolean setSername(String sername) {
        if (sername.isEmpty()||sername.equals("Null")||sername.matches(".*\\d+.*")) {return false;}
        this.sername = sername;
        return true;

    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        //to complite
        if (email.isEmpty()||email.equals("Null")||!(email.contains("@"))) {return false;}
        this.email = email;
        return true;

    }




}
