/**
 * Created by roznalex on 13.03.2015.
 */
public class Reverse {
    public static void main(String[] args) {
        Reverse test = new Reverse();
        test.reverseText("мама мыла раму");
    }

    void reverseText(String line) {
        int temp = 0;
        for (int i = 0; i < line.length(); i++) {
            if ((line.charAt(i) == ' ') || (i == line.length() - 1)) {
                for (int j = i; j > temp; j--) {
                    if (j == line.length() - 1) {
                        System.out.print(line.charAt(j));
                    }
                    System.out.print(line.charAt(j - 1));
                }
                temp = i + 1;
                if (i != line.length() - 1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
