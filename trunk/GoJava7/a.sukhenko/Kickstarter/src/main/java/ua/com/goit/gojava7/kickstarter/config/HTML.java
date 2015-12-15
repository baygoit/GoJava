package ua.com.goit.gojava7.kickstarter.config;

public class HTML{
    public static final String TITLE_HEAD_BODY = "</title></head><body>";
    public static final String HTML_HEAD_TITLE = "<html><head><title>";
    public static final String BODY_HTML_CLOSE = "</body></html>";
    public static final String HOME_LINK       = "<a href=\"kickstarter\"\\> <strong>Kickstarter</strong> </a><br/>";
    public static final String FORM            = "<form action=\"payment.jsp\" method=\"post\">" +
                                                       "Card<br>" +
                                                       "<input type=\"text\" name=\"card\"> " +
                                                       "<br>" +
                                                       "Last name:<br> " +
                                                       "<input type=\"text\" name=\"lastname\">" +
                                                       "</form>";

}
