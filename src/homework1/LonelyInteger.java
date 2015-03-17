package homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Alex on 14.03.2015.
 */
public class LonelyInteger {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arrayStr = reader.readLine().split(" ");
        int[] array = new int[arrayStr.length];
        for (int i=0;i<array.length;i++) {
            array[i] = Integer.parseInt(arrayStr[i]);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i:array) {
            String s = Integer.toBinaryString(i);
            s = new StringBuffer(s).reverse().toString();
            char[] chars = s.toCharArray();
            for (int j=0;j<chars.length;j++) {
                if (j>list.size()-1) {
                    list.add(0);
                }
                if (chars[j]=='1') {
                    list.set(j, list.get(j) + 1);
                }
            }
        }
        for (int i=0;i<list.size();i++) {
            if (list.get(i)%3==0) {
                list.set(i, 0);
            } else {
                list.set(i, 1);
            }
        }
        String result = "";
        for (int i:list) {
            result += i;
        }
        result = new StringBuffer(result).reverse().toString();
        System.out.println(Integer.parseInt(result, 2));
    }
}
