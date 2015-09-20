
public class BinNumber extends AbstractNumber {

	@Override
	public void setNumber(String textValue) {
		val=Integer.parseInt(textValue, 2);
		
	}

	@Override
	public String toString() {
		return Integer.toBinaryString(val)+"(2)";
		
	}

	@Override
	public void add(AbstractNumber an) {
		val=val+an.getNumber();
		
	}

}
