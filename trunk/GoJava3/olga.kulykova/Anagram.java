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
        String[] array = text.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            sb.reverse();
            array[i] = sb.toString();
            sb.delete(0, sb.length());
        }

        for (int i = 0; i < array.length; i++) {
            if (i == (array.length - 1)) {
                sb.append(array[i]);
            } else {
                sb.append(array[i]);
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
