
public class HexNumber extends AbstractNumber {

	@Override
	public void setNumber(String textValue) {
		val=Integer.parseInt(textValue, 16);
		
	}

	@Override
	public String toString() {
		return Integer.toHexString(val)+"(16)";
	}

	@Override
	public void add(AbstractNumber an) {
		val=val+an.getNumber();
		
	}

}
