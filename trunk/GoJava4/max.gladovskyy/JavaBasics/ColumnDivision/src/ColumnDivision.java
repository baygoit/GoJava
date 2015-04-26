import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ColumnDivision {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String dividend = reader.readLine();
		String devizor =  reader.readLine();
		int declimit = 5;
		new ColumnDivision(dividend,devizor,declimit);
	}
	
	ArrayList<Character> dividend = new ArrayList<Character>();
	ArrayList<Character> devizor = new ArrayList<Character>();
	ArrayList<Character> divresult = new ArrayList<Character>();
	ArrayList<Character>[] res = new ArrayList[2];
	ArrayList<String> division = new ArrayList<String>();
	boolean abovezero = true;
	int n=-1,i=0,j;
	
	public ColumnDivision(String dividend, String devizor, int declimit) {
		this.dividend.addAll(charArToList(dividend.toCharArray()));
		this.devizor.addAll(charArToList(devizor.toCharArray()));
		
		division.add(dividend+" |"+devizor);
		
		while (n < declimit) {
			res = takeMinDiv(this.dividend,this.devizor);
			if (res!=null) {
				if (i!=0) division.set(division.size()-1,spaceGen(i-1)+Integer.parseInt(getStr(res[0])));
				j = oneDivOp(res[0],this.devizor,i);
				this.dividend = charArToList((""+j).toCharArray());
				this.dividend.addAll(res[1]);
				skipNulls();
				if (j==0 && res[1].size()==0) break;
				i++;
			} else {
				
				i++;
				this.dividend.add('0');
				if (n==-1) this.divresult.add('0');
				if (abovezero) {
					this.divresult.add('.');
					abovezero = false;
				}
				n++;
			}

		}
		
		division.set(0,dividend+" |"+devizor);
		division.set(1,division.get(1)+spaceGen(charArToList(dividend.toCharArray()).size()-division.get(1).length())+" |"+getStr(divresult));
		for(String s: division) System.out.println(s);
		
	}
	
	private void skipNulls() {
		while (this.dividend.size()>0) {
			if (this.dividend.get(0)=='0'){
				this.divresult.add('0');
				this.dividend.remove(0);
				this.i++;
			} else break;
		}
	}
	
	private ArrayList<Character> charArToList (char[] c) {
		ArrayList<Character> a = new ArrayList<Character>();
		for (Character c1: c) {
			a.add(c1);
		}
		return a;
	}
	
	private ArrayList<Character>[] takeMinDiv (ArrayList<Character> dividend, ArrayList<Character> devizor) {
		ArrayList<Character>[] ret = new ArrayList[2];
		ArrayList<Character> d1, d2;
		int i1,i2;

		if (dividend.size() >= devizor.size()) {
			d1 = new ArrayList<Character>(dividend.subList(0, devizor.size()));
			d2 = devizor;
			i1 = Integer.parseInt(getStr(d1));
			i2 = Integer.parseInt(getStr(d2));
			if (i1 >= i2) {
				ret[0] = d1;
				ret[1] = new ArrayList<Character>(dividend.subList(devizor.size(), dividend.size()));
				return ret;
			} else if (dividend.size() > devizor.size()) {
				d1 = new ArrayList<Character>(dividend.subList(0, devizor.size()+1));
				ret[0] = d1;
				ret[1] = new ArrayList<Character>(dividend.subList(devizor.size()+1, dividend.size()));
				return ret;
			} 
		} 
		return null;
		
	}
	
	private int oneDivOp (ArrayList<Character> dividend, ArrayList<Character> devizor, int spaces) {
	int i1,i2;
	i1 = Integer.parseInt(getStr(dividend));
	i2 = Integer.parseInt(getStr(devizor));
		division.add(spaceGen(spaces-1)+(i2*(i1/i2)));
		division.add(spaceGen(spaces-1)+delimGen(dividend.size()+1));
		division.add(spaceGen(spaces-1)+(i1%i2));
		this.divresult.add(((i1/i2)+"").toCharArray()[0]);
		return i1%i2;
	}
	
	
	private String getStr (ArrayList<Character> list) {
	    StringBuilder builder = new StringBuilder(list.size());
	    for(Character ch: list)
	    {
	        builder.append(ch);
	    }
	    return builder.toString();
	}
	
	private String spaceGen (int j) {
		String s = "";
		for (int i=0; i<j; i++) {
			s+=" ";
		}
		return s;
	}
	
	private String delimGen (int j) {
		String s = "";
		for (int i=0; i<j; i++) {
			s+="-";
		}
		return s;
	}
}
