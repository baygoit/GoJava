package kickstarter.page;

import java.io.IOException;
import java.util.Map;

public interface IPage {
    
    public void run(Map<String, String> map) throws IOException;
    
    public State makeChoice(Map<String, String> map) throws IOException;
}
