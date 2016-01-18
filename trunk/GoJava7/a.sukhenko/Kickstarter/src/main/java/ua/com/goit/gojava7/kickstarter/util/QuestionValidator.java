package ua.com.goit.gojava7.kickstarter.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.vo.QuestionVO;
@Component
public class QuestionValidator implements org.springframework.validation.Validator{
    
    @Autowired
    private Validator validator;
    
    @Override
    public boolean supports(Class<?> clazz) {
        return QuestionVO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "question", "error.question","Question should not be empty.");
      
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
