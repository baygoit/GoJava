import java.util.Stack;


public class RomeNumber extends AbstractNumber{

	@Override
	public void setNumber(String textValue) {
		Stack<Integer> stackInt=new Stack();
		int i=0;
		while (i<textValue.length())
		{
			if(i!=textValue.length()-1)
				if(converToInt(textValue.charAt(i))>=converToInt(textValue.charAt(i+1)))
				{
					stackInt.push(converToInt(textValue.charAt(i)));
					i++;
				}
				else
				{
					stackInt.push(converToInt(textValue.charAt(i+1))-converToInt(textValue.charAt(i)));
					i=i+2;
				}
			else
			{
				stackInt.push(converToInt(textValue.charAt(i)));
				i++;
			}
		}


		while(stackInt.size()!=0)
		{
			val=val+stackInt.pop();
		}

	}

	@Override
	public String toString() {
		return converToRome(val)+"(r)";

	}

	@Override
	public void add(AbstractNumber an) {
		val=val+an.getNumber();

	}

	private static int converToInt(char ch){
		switch(ch)
		{
		case 'I': return 1;
		case 'V':return 5;
		case 'X':return 10;
		case 'L':return 50;
		case 'C':return 100;
		case 'D':return 500;
		case 'M': return 1000;
		}
		return 0;
	}

	private static String converToRome(int intVal){
		String out="";
		if(intVal>3999)
			return "Out of range";
		int temp=intVal/1000;
		for(int i=1; i<=temp; i++)
		{
			out=out+"M";
		}
		temp=intVal%1000;

		if(temp/100==9)
		{
			out+="CM";
			temp=temp%100;
		}
		if(temp/500==1)
		{
			out+="D";
			temp=temp%500;
		}
		if(temp/100==4)
		{
			out+="CD";
		}
		else
		{
			for(int i=1; i<=temp/100; i++)
			{
				out=out+"C";
			}
		}
		temp=temp%100;
		if(temp/10==9)
		{
			out+="XC";
			temp=temp/10;
		}
		if(temp/50==1)
		{
			out+="L";
			temp=temp%50;
		}
		if(temp/10==4)
			out+="XL";
		else
		{
			for(int i=1; i<=temp/10; i++)
			{
				out=out+"X";
			}
		}
		temp=temp%10;
		if(temp==9)
		{
			out+="IX";
			temp=temp/10;
		}
		if(temp/5==1)
		{
			out+="V";
			temp=temp%5;
		}
		if(temp/4==1)
			out+="IV";
		else
			for(int i=1; i<=temp/5; i++)
			{
				out=out+"X";
			}
		return out;
	}
}
