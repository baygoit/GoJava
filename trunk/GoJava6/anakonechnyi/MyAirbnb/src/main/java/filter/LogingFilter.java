package filter;

/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @autor A_Nakonechnyi
 * @date 20.11.2015.
 */
public class LogingFilter implements Filter{

    //private static final Logger logger = LogManager.getLogger(LogingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        // if session doesn't exist, forward user to welcome page
        if (req.getSession() == null
                || !isCredsValid(req)) {
            try {
                System.out.println("to login.jsp");
                req.getRequestDispatcher("/Login.jsp").forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        filterChain.doFilter(request, response);
    }

    private boolean isCredsValid(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        String pass = (String) session.getAttribute("pass");
        ServletContext servletContext =
                request.getServletContext();
        if(user == null || pass == null) {
            //logger.info("you are not logged in");
            return false;
        }
        else if (!user.equals(servletContext.getInitParameter("user"))
                || !pass.equals(servletContext.getInitParameter("pass"))) {
            //logger.error("invalid user or password, user: " + user + " , pass: " + pass);
            return false;
        }

        return true;
    }

    @Override
    public void destroy() {

    }
}
