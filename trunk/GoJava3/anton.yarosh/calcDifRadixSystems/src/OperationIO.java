import java.util.Scanner;


public class OperationIO {


	public AbstractNumber input(){
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		AbstractNumber an=null;
		if(input.indexOf(")")==-1)
		{
			an=new DecNumber();
			an.setNumber(input);
			return an;
		}
		if(input.charAt(input.length()-2)=='2')
		{
			an=new BinNumber();
			an.setNumber(input.substring(0, input.indexOf("(")));
			return an;
		}
		if(input.charAt(input.length()-2)=='8')
		{
			an=new OctNumber();
			an.setNumber(input.substring(0, input.indexOf("(")));
			return an;
		}
		if(input.charAt(input.length()-2)=='6')
		{
			an=new HexNumber();
			an.setNumber(input.substring(0, input.indexOf("(")));
			return an;
		}
		if(input.charAt(input.length()-2)=='r')
		{
			an=new RomeNumber();
			an.setNumber(input.substring(0, input.indexOf("(")));
			return an;
		}
		return an;
	}

	public void output(AbstractNumber an){
		System.out.println(an);
	}

}
