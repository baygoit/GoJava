
public class Main {


	public static void main(String[] args) {
		OperationIO op=new OperationIO();
		AbstractNumber firstNumber=op.input();
		AbstractNumber secondNumber=op.input();
		firstNumber.add(secondNumber);
		op.output(firstNumber);
	}

}
