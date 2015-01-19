import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Check {
	public static boolean checkEqual(String userString){  
        Pattern p = Pattern.compile("^[a-z0-9_-]{3,15}$");//TODO
        Matcher m = p.matcher(userString);  
        return m.matches();  
    }
}
