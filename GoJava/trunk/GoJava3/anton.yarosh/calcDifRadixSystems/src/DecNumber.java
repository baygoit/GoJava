public class DecNumber extends AbstractNumber {
	public String toString(){
		return val+"";
	}

	public void setNumber(String textValue) {
		val=Integer.parseInt(textValue);	
	}

	@Override
	public void add(AbstractNumber an) {
		val=val+an.getNumber();
		
	}
}


