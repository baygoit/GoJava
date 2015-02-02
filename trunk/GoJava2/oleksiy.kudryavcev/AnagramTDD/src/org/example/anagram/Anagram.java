package org.example.anagram;
public class Anagram {

    public String makeAnagram(String string) {
        String[] parts = string.split(" ");
        StringBuilder word = new StringBuilder("");
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < parts.length; i++) {
            word.append(parts[i]).reverse();
            if (i == (parts.length - 1)) {
                result.append(word);
            } else {
                result.append(word).append(" ");
            }
            word.setLength(0);
        }
        return result.toString();
    }
}
