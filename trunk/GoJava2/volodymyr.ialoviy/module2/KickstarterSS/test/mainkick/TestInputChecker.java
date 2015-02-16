package mainkick;

import static org.junit.Assert.*;

import org.junit.Test;

import util.InputChecker;

public class TestInputChecker {

	@Test
    public void sendEmptyStringNumber_whenRezultFalse(){
		Boolean rezult = InputChecker.checkNumber(new int[] {1,4,6}, "");
		assertEquals(rezult, false);
	}
	
	@Test(expected = NullPointerException.class)
    public void sendNull_whenRezultFalse(){
		String s = null;
		Boolean rezult = InputChecker.checkNumber(new int[] {1,4,6}, s);
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendLetter_whenRezultFalse(){
		Boolean rezult = InputChecker.checkNumber(new int[] {1,4,6}, "o");
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendNumberOutOfRange_whenRezultFalse(){
		Boolean rezult = InputChecker.checkNumber(new int[] {1,4,6}, "0");
		assertEquals(rezult, false);
	}

	@Test
    public void sendNumberOutOfRange_whenRezultFalse2(){
		Boolean rezult = InputChecker.checkNumber(new int[] {1,4,6}, "2");
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendNumberOfRange_whenRezultTrue(){
		Boolean rezult = InputChecker.checkNumber(new int[] {1,4,6}, "4");
		assertEquals(rezult, true);
	}

	@Test
    public void sendEmptyStringName_whenRezultFalse(){
		Boolean rezult = InputChecker.checkName("");
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendNumber_whenRezultFase(){
		Boolean rezult = InputChecker.checkName("4");
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendNameOneLetter_whenRezultFase(){
		Boolean rezult = InputChecker.checkName("t");
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendNameTwentyOneLetter_whenRezultFase(){
		Boolean rezult = InputChecker.checkName("twertyduhfjiqbcfdsazx");
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendCorectName_whenRezultTrue(){
		Boolean rezult = InputChecker.checkName("Kate");
		assertEquals(rezult, true);
	}
	
	@Test
    public void sendEmptyStringCard_whenRezultFolse(){
		Boolean rezult = InputChecker.checkCard("");
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendLetters_whenRezultFolse(){
		Boolean rezult = InputChecker.checkCard("Kate");
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendTwoNumerals_whenRezultFolse(){
		Boolean rezult = InputChecker.checkCard("11");
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendSeventeenNumerals_whenRezultFolse(){
		Boolean rezult = InputChecker.checkCard("11112222333344445");
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendSixteenNumerals_whenRezultTrue(){
		Boolean rezult = InputChecker.checkCard("1111222233334444");
		assertEquals(rezult, true);
	}
	
	@Test
    public void sendEmptyStringAmount_whenRezultFalse(){
		Boolean rezult = InputChecker.checkAmount("");
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendLetterInAmount_whenRezultFalse(){
		Boolean rezult = InputChecker.checkAmount("ewter");
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendNegativeValuesAmount_whenRezultFalse(){
		Boolean rezult = InputChecker.checkAmount("-2");
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendMoreThan100Billion_whenRezultFalse(){
		Boolean rezult = InputChecker.checkAmount("10000000000");
		assertEquals(rezult, false);
	}
	
	@Test
    public void sendCorectAmount_whenRezultTrue(){
		Boolean rezult = InputChecker.checkAmount("100");
		assertEquals(rezult, true);
	}
}