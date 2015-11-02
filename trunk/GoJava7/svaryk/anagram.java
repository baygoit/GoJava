import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class anagram {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Write text for reverse");
        String textToReverse = reader.readLine();
        String str = textToReverse;
        str = new StringBuffer(str).reverse().toString();
        System.out.println(str);
    }
}
