import java.util.Arrays;
import java.util.Scanner;
public class Dividing2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//String input=sc.nextLine();
		String input = "-100/-7";
		String outBefore = "";
		String outAfter = "\n ";
		String outFinal = "";
		int poz = 0;
		int rez = 0;
		boolean fl = false;
		boolean fIter = false;
		String result = "";
		int lengthA = 0;
		int lengthB = 0;
		boolean isNegativeA = false;
		boolean isNegativeB = false;
		int koefA = 0;
		int koefB = 0;
		int shift = 0;
		if (input.split("/")[0].charAt(0) != '-') {
			lengthA = input.split("/")[0].length();
			koefA = 1;
			poz = 1;
		}
		else {
			lengthA = input.split("/")[0].length() - 1;
			isNegativeA = true;
			koefA=-1;
			poz = 2;
			shift = 1;
		}
		if (input.split("/")[1].charAt(0) != '-') {
			lengthB = input.split("/")[1].length();
			koefB = 1;
		}
		else {
			lengthB = input.split("/")[1].length() - 1;
			isNegativeB=true;
			koefB=-1;
		}
		int sign = koefA * koefB;
		int gap = lengthA;
		int iter = lengthB - lengthA;
		int a = Math.abs(Integer.parseInt(input.split("/")[0]));
		int b = Math.abs(Integer.parseInt(input.split("/")[1]));
		int tmp = (int) ((a / Math.pow(10, lengthA - 1))
				          / (b / Math.pow(10, lengthB - 1)));
		int ost = a;
		if(ost < b) {
			ost *= Math.pow(10, lengthB - lengthA + 1 - tmp);
			result += "0.";
			for (int i = tmp; i < lengthB - lengthA; i++){
				result+="0";
			}
			fl = true;
			lengthA = toString(ost).length();
		}
		gap = lengthA - gap;
		if (isNegativeA) {
			outBefore += "_-" + a;
		}
		else {
			outBefore += "_" + a;
		}
		for (int i = 1; i <= gap; i++) {
			outBefore += " ";
		}
		if (isNegativeB) {
			outBefore += "|-" + b + "\n";
		}
		else {
			outBefore += "|" + b + "\n";

		}
		int i = 0;
		for (i = lengthA - 1;i >= 0; i--) {
			if (ost / Math.pow(10, i) < b){
				continue;
			}
			else {
				rez = (int) ((ost / Math.pow(10, i)) / b) * sign;
				result += rez + "";
				break;
			}
		}
		if(i==0){
			for (int j = 1; j <= lengthA - toString(b * rez * sign).length() + 1; j++) {
				outBefore += " ";
			}
		}
		else {
			for (int j = 1; j <= lengthA - i - toString(b * rez * sign).length() + 1; j++) {
				outBefore += " ";
			}
		}
		outBefore += rez * b * koefB;
		for (int j = 1; j <= i; j++){
			outBefore += " ";
		}
		outBefore += "|";
		ost = (int) ((ost / Math.pow(10, i)) % b);
		outAfter = "\n";
		for (int j = 1; j <= poz; j++){
			outAfter+=" ";
		}
		if(i != 0){
			for (int j = 1; j <= lengthA - i; j++) {
				outAfter += "-";
			}
		}
		else{
			for (int j = 1; j <= lengthA; j++) {
				outAfter += "-";
			}
		}
		outAfter += "\n";
		boolean flag = false;
		int lastOst = rez * b;
		while ((ost != 0) && (iter <= 100) || (i != 0)) {
			ost = (int) (ost * Math.pow(10, 1)
					     + (a % Math.pow(10, i)) / Math.pow(10, i-1));
			for (int j = 1; j <= poz - shift; j++) {
				outAfter += " ";
			}
			if (isNegativeA) {
				outAfter += "_-" + ost + "\n";
			}
			else {
				outAfter += "_" + ost + "\n";
			}
			if (fIter || fl) {
				iter++;
			}
			else {
				i--;
			}
			rez = (ost / b);
			for (int j = 1; j <= poz + 1 - shift + toString(ost).length() 
					- toString(rez * b).length(); j++) {
				outAfter += " ";
			}
			outAfter += rez * b * sign * koefB + "\n";
			lastOst = ost;
			poz++;
			for (int j = 1; j <= poz; j++) {
				outAfter += " ";
			}
			for (int j = 1; j <= toString(ost).length(); j++) {
				outAfter += "-";
			}
			outAfter += "\n";
			ost = ost % b;
			result += rez + "";
			if (( i==0 ) && !fl && !fIter && (ost != 0)) {
				result += ".";
				fIter = true;
			}
		}
		if (ost == 0) {
			for (int j = 1; j <= poz + toString(lastOst).length() - 1; j++) {
				outAfter+=" ";
			}
			outAfter += ost + "\n";
		}
		if (iter >= 100) {
			String pattern = lrs(result.substring(result.indexOf('.') + 1));
			int z = result.indexOf(pattern, result.indexOf('.') + 1);
			StringBuffer sb = new StringBuffer(result);
			sb.delete(result.indexOf(pattern, z + 1), sb.length());
			sb.replace(z, sb.length(), "(" + pattern + ")");
			int lengthOutAfter = sb.toString().length() - 3;
			int m = 0;
			for(int j = 1; j < lengthOutAfter; j++){
				m = outAfter.indexOf("_", m+1);
			}
			outAfter = outAfter.substring(0, m);
			System.out.println(outBefore + sb.toString() + outAfter);
		}
		else {
			System.out.println(outBefore + result + outAfter);
		}
	}

	private static String toString(int k){
		return new String(k+"");
	}

	private static String lcp(String s, String t) {
		int n = Math.min(s.length(), t.length());
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != t.charAt(i))
				return s.substring(0, i);
		}
		return s.substring(0, n);
	}

	private static String lrs(String s) {
		int n  = s.length();
		String[] suffixes = new String[n];
		for (int i = 0; i < n; i++) {
			suffixes[i] = s.substring(i, n);
		}
		Arrays.sort(suffixes);
		String lrs = "";
		for (int i = 0; i < n - 1; i++) {
			String x = lcp(suffixes[i], suffixes[i + 1]);
			if (x.length() > lrs.length())
				lrs = x;
		}
		if (lrs.equals("")) {
			return "";
		}
		if (lrs.length()==1) {
			return lrs;
		}
		if ((lrs.charAt(0) != lrs.charAt(1)) && (lrs(lrs).length() == 1)){
			return lrs;
		}
		return lrs(lrs);
	}
}
