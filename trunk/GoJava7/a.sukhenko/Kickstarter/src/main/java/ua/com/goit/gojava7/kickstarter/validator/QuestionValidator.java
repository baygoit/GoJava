package ua.com.goit.gojava7.kickstarter.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import ua.com.goit.gojava7.kickstarter.model.Question;
@Repository
@Transactional
public class QuestionValidator implements org.springframework.validation.Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Question.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "question", "error.question", "Question should not be empty.");
        validateQuestion(target, errors);

    }

    public void validateQuestion(Object target, Errors errors) {
        Question question = null;

        if (target.getClass() == Question.class) {
            question = (Question) target;

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
            Matcher m = p.matcher(question.getQuestion());
            if (!m.matches()) {
                errors.rejectValue("question", "error.question_invalid", " Question isn't valid");
            }

        }

    }
}
