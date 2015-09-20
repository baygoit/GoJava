import java.math.BigInteger;


public abstract class AbstractNumber {
	protected int val;
	public abstract void setNumber(String textValue);
	public abstract String toString();
	public abstract void add(AbstractNumber an);
	public int getNumber(){
		return val;
	}
}
