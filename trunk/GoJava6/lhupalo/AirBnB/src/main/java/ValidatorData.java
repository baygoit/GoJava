/**
 * Created by  L Hupalo on 23.09.2015.
 */
public class ValidatorData {

    // validation name and surname and city
    public static boolean validateWords(String word) {
        if (word == null || word.isEmpty() || isOnlyLetter(word) == false) {
            System.out.println("Uncorrect data in word");
            return false;
        }
        return true;
    }

    public static boolean validateEmail(String email) {
        if (isValidEmailAddress(email) == false || email == null
                || email.isEmpty()) {
            System.out.println("Uncorrect data in email");
            return false;
        }
        return true;
    }


    // inner methods
    protected static boolean isOnlyLetter(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    protected  static boolean isValidEmailAddress(String email) {
        if (email.isEmpty() || email.equals("Null")
                || !(email.contains("@")) || !(email.contains("."))) {
            return false;
        }

        return true;
    }

}

