package mainkick;

public class OutputConsole implements Output{
	@Override
	public void print(String string){
		System.out.println(string);
	}
}