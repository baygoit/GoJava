package division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static List<String> resultList = new ArrayList<>();
	
	public static void main(String[] args) {
		Main main = new Main();
		List<String> stringData = main.readData();
		int accuracy = 1;
		List<String> helpList = main.division(stringData, accuracy);
		System.out.println(helpList);
		System.out.println(resultList);
	}

	private List<String> division(List<String> stringData, int accuracy) {
		List<String> helpList = new ArrayList<>();
		List<Integer> intData = getIntData(stringData);
		//int dividen = intData.get(0);
		int divider = intData.get(1);
		List<String> dividendStrList = makeDividendStrList(stringData.get(0));
		//int count = dividendStrList.size();
		int index = 0;
		int remainder = 0;
		int helpNumber = Integer.parseInt(dividendStrList.get(index));
		while (index != dividendStrList.size()-1 || remainder !=0) {
			
			if (helpNumber >= divider) {
				System.out.println("index	"+index);
				helpList.add(String.valueOf(helpNumber));
				int resultNumber = helpNumber/divider;
				System.out.println("resultNumber	"+resultNumber);
				resultList.add(String.valueOf(resultNumber));
				helpList.add(String.valueOf(divider*resultNumber));
                remainder = helpNumber%divider;
                System.out.println("remainder	"+remainder);
                if(index == dividendStrList.size()-1){
                	break;
                }
                
                String helpNumberStr = remainder+dividendStrList.get(++index);
                helpNumber = Integer.parseInt(helpNumberStr);
                if (helpNumber < divider) {
					resultList.add("0");
				}
                System.out.println("helpNumberIN	"+helpNumber);
                System.out.println("-----------------------");
                
			} else {
				//count--;
				System.out.println("index	"+index);
				index++;
				String newStr = helpNumber+dividendStrList.get(index);
				//System.out.println("newStr "+newStr);
				helpNumber = Integer.parseInt(newStr);
				if (helpNumber < divider) {
					resultList.add("0");
				}
				//remainder = helpNumber%divider;
				System.out.println("helpNumber:	"+helpNumber);
			}

		} 
		return helpList;
	}

	private List<String> makeDividendStrList(String string) {
		String[] dividendStrArr = string.split("");
		List<String> dividendStrList = new ArrayList<>();
		for (int i = 1; i < dividendStrArr.length; i++) {
			dividendStrList.add(dividendStrArr[i]);
		}
		return dividendStrList;
	}

	private List<Integer> getIntData(List<String> stringData) {
		List<Integer> intData = new ArrayList<>();
		int upNumber = Integer.parseInt(stringData.get(0));
		int downNumber = Integer.parseInt(stringData.get(1));

		if (upNumber*downNumber > 0) {
			intData.add(Math.abs(upNumber));
			intData.add(Math.abs(downNumber));
		} else {
			if (upNumber < 0 || downNumber < 0) {
				intData.add(Math.abs(upNumber));
				intData.add(Math.abs(downNumber));
                resultList.add("-");
			}
		}
		return intData;
	}

	private List<String> readData() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<String> result = new ArrayList<String>();
		String dividend = "";
		String divider = "";
		System.out.println("Enter the dividend");
		try {
			dividend = reader.readLine();
			if (isValid(dividend)) {
				System.out.println("Enter the divider");
				divider = reader.readLine();
				if (isValid(divider)) {
					result.add(dividend);
					result.add(divider);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	private boolean isValid(String str) {
		boolean b = false;
		try {
			Integer.parseInt(str);
			b = true;
		} catch (NumberFormatException e) {
			System.out.println("Wrong entering!");
		}
		return b;
	}

}
