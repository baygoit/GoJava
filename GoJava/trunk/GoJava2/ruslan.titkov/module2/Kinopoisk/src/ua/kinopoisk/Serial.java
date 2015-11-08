
package ua.kinopoisk;

import java.util.Scanner;

public class Serial {
	String  title;
	int season;
	int episode;

	public void setTitle() // Метод для присваивания значения (set)
	
	{
		
		System.out.println("Веедите название сериала:");
		Scanner scanner = new Scanner (System.in);
		title = scanner.nextLine();

	}
	
	public void setSeason()
     	{
		
		System.out.println("Веедите номер сезона:");
		Scanner scanner = new Scanner (System.in);
		season = scanner.nextInt();

     	}
	
	public void setEpisode()
 			{
	
	System.out.println("Веедите номер серии:");
	Scanner scanner = new Scanner (System.in);
	episode = scanner.nextInt();

 			}
	
    public String getTitle() // Метод для получения/возвращения значения (get)
	
				{
		
		return title;
				}
	
    public int getEpisode()
	
    					{
   		
   		return episode;
    					}
    
    public int getSeason()
	
							{

        return season;
							}

}
