import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ольга on 11.03.2015.
 */

/*
На вход консольного приложения передается строка слов, разделенных пробелами.
Твоя задача сделать из слов анаграммы ("задом наперед") при этом оставив порядок слов неизменными.
Результат вывести в консоль. Пример "мама мыла раму" => "амам алым умар"
*/

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        StringBuilder word = new StringBuilder();
        StringBuilder newText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (' ' != text.charAt(i)) {
                word.append(text.charAt(i));
            } else {
                newText.append(word.reverse());
                word.delete(0, word.length());
                newText.append(" ");
            }
        }
        newText.append(word.reverse());

        System.out.println(newText);
    }
}
