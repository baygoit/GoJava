package Lessons1.LonelyNumber;

import com.sun.org.apache.xml.internal.security.utils.XMLUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 28.06.15
 * Time: 7:46
 * @version: 1.0
 */
public class Main {
    public static void main(String args[]){
        HashMap<Integer,Integer> locHashMap = new HashMap<Integer, Integer>(7, 1);
        String[] inputString;
        Integer temp, locVar;

        System.out.println("Input 7 int. elements of array. All of them must be duplicate and only one - single");
        Scanner locScanner = new Scanner(System.in);
        inputString = locScanner.nextLine().split(" ");
        for (int i = 0; i < inputString.length; i++) {
            temp = Integer.parseInt(inputString[i]);
            if (locHashMap.containsKey(temp)) {
                locVar = locHashMap.get(temp);
                locHashMap.put(temp, ++locVar);
            } else {
                locHashMap.put(temp, 1);
            }
        }
        for (Map.Entry<Integer, Integer> elem : locHashMap.entrySet()){
            if (elem.getValue() == 1) {
                System.out.println("Lonely number - " + elem.getKey());
            }
        }
    }
}
