/**
 * Created by roznalex on 13.03.2015.
 */
public class Reverse {
    public static void main(String[] args) {
        Reverse test = new Reverse();
        String result = test.reverseText("мама мыла раму");
        System.out.println(result);
    }

    /**
     * Function for revers the line
     * "мама мыла раму"-->"амам алым умар"
     *
     * @param line Input line of text
     * @return result Reversed line of text
     */
    String reverseText(String line) {
        String temp = "";
        String result = "";

        for (int i = 0; i < line.length(); i++) {
            temp += line.charAt(i);
            if ((line.charAt(i) == ' ') || (i == line.length() - 1)) {
                if (i == line.length() - 1) {
                    temp += " ";
                }
                for (int j = temp.length() - 2; j >= 0; j--) {
                    result += temp.charAt(j);
                    if((j == 0) && (i != line.length() - 1))
                        result += " ";
                }
                temp = "";
            }
        }

        return result;
    }
   /* Version with additional using od memory

   String reverseText(String line) {
        StringBuilder builder = new StringBuilder(line.length());
        String reversedLine;
        String resultLine = "";
        char[] chars = line.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            builder.append(chars[i]);
        }
        reversedLine = builder.toString();

        String[] result = reversedLine.split(" ");
        for (int  i = result.length - 1; i >= 0; i--) {
            resultLine += result[i] + " ";
        }
        return resultLine.trim();
    }

    */
}
