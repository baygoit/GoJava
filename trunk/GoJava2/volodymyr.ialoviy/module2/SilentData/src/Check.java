import java.util.regex.Pattern;


public class Check {
	public boolean checkEqual(String userString){  
        Pattern p = Pattern.compile("^[a-z0-9_-]{3,15}$");//TODO
        return p.matcher(userString).matches();  
    }
}
