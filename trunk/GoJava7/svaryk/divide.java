import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class divide {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int dividend, divisor, temp;
        String strRes;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            System.out.println("Enter dividend");
            String strDividend = reader.readLine();
            dividend = Integer.parseInt(strDividend);

            System.out.println("Enter divisor");
            String strDivisor = reader.readLine();
            divisor = Integer.parseInt(strDivisor);

        reader.close();
        if (dividend < divisor) {
            strRes = "0,";
        }
        else {
            temp = dividend/divisor;
            dividend -= temp*divisor ;
            strRes = String.valueOf(temp);
            if (dividend % divisor != 0) strRes+=",";
        }

        String result = "";
        String tab = "";
        while (dividend != 0) {
            tab += " ";
            map.put(dividend, strRes.length());
            dividend *= 10;
            result += tab + "---\n" + tab + dividend + "\n" + tab + dividend/divisor*divisor + "\n";

            if (dividend < divisor) {
                strRes += "0";
                continue;
            }
            temp = dividend/divisor;
            dividend = dividend%divisor;
            strRes += String.valueOf(temp);
            if (map.containsKey(dividend)) {
                strRes = strRes.substring(0, map.get(dividend)) + "(" + strRes.substring(map.get(dividend)) + ")";
                break;
            }
        }
        strRes = dividend + " |" + divisor + "\n" + dividend/divisor*divisor + " |" + strRes;
        System.out.println(strRes);
        System.out.println(result);

    }

}

