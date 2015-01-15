

package anagramma;

import java.util.Scanner;


public class anagramma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner input = new Scanner (System.in);
		String phrase = input.nextLine();

		int lenPhrase = phrase.length();
		String phraseArray[][] = new String[lenPhrase+1][lenPhrase] ;
		int lenWords[] = new int[lenPhrase];
		int word = 1;
		
		System.out.println(lenPhrase);
		
		for (int i = 0; i < lenPhrase; i++)
		{
			
			phraseArray[i][word] = String.valueOf(phrase.charAt(i));
		
			if (phraseArray[i][word].equalsIgnoreCase(" "))
				{
					lenWords[word] = i;
					word++;
				}
			
		}
		
		lenWords[word] = lenPhrase;
		phraseArray[lenPhrase][word] = String.valueOf(phrase.charAt(lenWords[1]));
		lenWords[0] = 0;
		
		
		
		for (int j = 1; j <= word; j++)
		{
				for (int i = lenWords[j]; i > lenWords[j - 1] ; i--)
					{
				
						if (j == 1) 
						{
						System.out.print(phraseArray[i-1][j]);
							
						} else  	{
									System.out.print(phraseArray[i][j]);
									}
					
					
					}
		}
			
		
		
	}

}
