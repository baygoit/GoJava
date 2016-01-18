package ua.com.goit.gojava7.kickstarter.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class Validator{

    private static final Logger log = LoggerFactory.getLogger(Validator.class);

    public boolean validateAmountOfPledge(String amount) {
        Pattern p = Pattern.compile("^[1-9]{1,10}$");
        Matcher m = p.matcher(amount);
        return m.matches();
    }

    public boolean validatePayer(String name, String card) {
        return validateName(name) & validateCard(card);
    }

    public boolean validateName(String name) {
        Pattern p = Pattern.compile("^[\\p{L} .'-]+$");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public boolean validateCard(String card) {
        Pattern p = Pattern.compile("^[0-9]{16}$");
        Matcher m = p.matcher(card);
        return m.matches();
    }

    public boolean validateQuestion(String question) {
        Pattern p = Pattern.compile(
                "# Match a sentence ending in punctuation or EOS.\n" +
                "[^.!?\\s]    # First char is non-punct, non-ws\n" +
                "[^.!?]*      # Greedily consume up to punctuation.\n" +
                "(?:          # Group for unrolling the loop.\n" +
                "  [.!?]      # (special) inner punctuation ok if\n" +
                "  (?!['\"]?\\s|$)  # not followed by ws or EOS.\n" +
                "  [^.!?]*    # Greedily consume up to punctuation.\n" +
                ")*           # Zero or more (special normal*)\n" +
                "[.!?]?       # Optional ending punctuation.\n" +
                "['\"]?       # Optional closing quote.\n" +
                "(?=\\s|$)", 
                Pattern.MULTILINE | Pattern.COMMENTS);
        Matcher m = p.matcher(question);
        return m.matches();
    }
}
