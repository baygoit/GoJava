
public class OctNumber extends AbstractNumber {

	@Override
	public void setNumber(String textValue) {
		val=Integer.parseInt(textValue, 8);
	}

	@Override
	public String toString() {
		return Integer.toOctalString(val)+"(8)";
	}

	@Override
	public void add(AbstractNumber an) {
		val=val+an.getNumber();
		
	}

}
