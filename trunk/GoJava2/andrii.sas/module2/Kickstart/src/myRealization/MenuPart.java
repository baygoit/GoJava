package myRealization;

public abstract class MenuPart {
	
	public int checkForCorrectInput(){
		int l = 0;
		while(true){
			try {
				l = inputNumber() - 1;
				if (l == -1){
					break;
				}
				getObject(l);
				break;
			} catch (IndexOutOfBoundsException e){
				typeError();
			}
		}
		return l;
	}
	
	abstract int inputNumber();
	
	abstract Object getObject(int i);
	
	abstract void typeError();

}
