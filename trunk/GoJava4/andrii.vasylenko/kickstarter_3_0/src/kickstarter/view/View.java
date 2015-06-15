package kickstarter.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface View {
	Map<String, Object> getParameters(HttpServletRequest request, HttpServletResponse response) throws Exception;

	void forward(HttpServletRequest request, HttpServletResponse response, Map<String, Object> data) throws Exception;
}
