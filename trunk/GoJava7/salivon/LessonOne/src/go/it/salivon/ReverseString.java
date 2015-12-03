package go.it.salivon;

import go.it.main.WordsReverse;

public class ReverseString extends WordsReverse {

    private String beginStr;
    private StringBuilder endStr;

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverseWords("12"));

    }

    private String printResult() {
        String outString = "Initial String - " + beginStr + "\n" + "End String - " + endStr;
        return outString;
    }

    private void reverseStr() {
        endStr = new StringBuilder(beginStr.length());
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < beginStr.length(); i++) {
            if (beginStr.charAt(i) == ' ') {
                str.reverse();
                endStr.append(str);
                endStr.append(beginStr.charAt(i));
                str.delete(0, str.length());
            }
            if (beginStr.charAt(i) != ' ' && i != beginStr.length() - 1) {
                str.append(beginStr.charAt(i));

            }
            if (i == beginStr.length() - 1 && beginStr.charAt(i) != ' ') {
                str.append(beginStr.charAt(i));
                str.reverse();
                endStr.append(str);

                str.delete(0, str.length());
            }
        }
    }

    @Override
    public String reverseWords(String phrase) {
        if (phrase == null) {
            return "do not enter text";
        }
        if (phrase.equals("")) {
            return "";
        }
        beginStr = phrase;
        reverseStr();
        return endStr.toString();
    }
}
