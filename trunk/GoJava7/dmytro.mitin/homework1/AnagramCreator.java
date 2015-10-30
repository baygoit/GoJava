/**
 * Created by Dmytro on 22.10.2015.
 */
public class AnagramCreator {
    public static void main(String[] args) {
        AnagramCreator anagramCreator = new AnagramCreator();
        System.out.println(anagramCreator.reverse("gjk hknlkdjc djcn kl"));
        System.out.println(anagramCreator.reverse1("gjk hknlkdjc djcn kl"));
        System.out.println(anagramCreator.reverse2("gjk hknlkdjc djcn kl"));
    }

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public String reverse1(String str) {
        int size = str.length();
        StringBuilder res = new StringBuilder(size);
        for (int i = size - 1; i >= 0; i--) {
            res.append(str.charAt(i));
        }
        return res.toString();
    }

    public String reverse2(String str) {
        int size = str.length();
        char[] res = new char[size];

        for (int i = 0; i < size; i++) {
            res[i] = str.charAt(size - i - 1);
        }
        return new String(res);
    }
}
