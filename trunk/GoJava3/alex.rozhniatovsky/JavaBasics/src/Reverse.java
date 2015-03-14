/**
 * Created by roznalex on 13.03.2015.
 */
public class Reverse {
    public static void main(String[] args) {
        Reverse test = new Reverse();
        String result = test.reverseText("мама мыла раму");
        System.out.println(result);
    }

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
}
