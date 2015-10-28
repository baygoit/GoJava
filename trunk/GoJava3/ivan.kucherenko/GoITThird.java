import java.util.ArrayList;

public class GoITThird {
		/*Проверено со следующими входными данными
		 * 62/42,12/42, 128989/76, 98676590/54645, 8/567, 90/120
		 * */
	
		private static int dividend, divider;
		
		//Метод который возвращает массив чисел из нашего делимого
		private static int[] nextInd(int firstdiv){

			char[] dividendString = String.valueOf(dividend).toCharArray();
			int firstIndex = String.valueOf(firstdiv).toCharArray().length; 
			int lastIndex = dividendString.length;
			int[] result = new int[lastIndex - firstIndex];
			int count = 0;
			int periodCount = 0;
			for (int i = firstIndex; i < lastIndex; i++)
			{
				result[count] = Integer.parseInt(dividendString[i]+"");
				count++;
			}
			return result;
		}

	public static void main(String[] args) {
		//Тут у нас будет результат
			StringBuilder result = new StringBuilder("");
		
		//Получаем наши значения в виде стринга
			String [] args1 = args[0].split("/");
		
		//Сюда мы будем складывать цифры после вычисления
			ArrayList<String> nums = new ArrayList<String>();
		
		//Получаем делимое и делитель
			dividend = Integer.parseInt(args1[0]);
			divider = Integer.parseInt(args1[1]);
		
		/*Получаем длинну делимого. 
	     *(необходимо в стандартной 
		 *ситуации деления бОльшего
		 * на меньшее)*/
		 	int lenth = args1[0].length();
		 	int [] firstMin = new int[lenth -1];
		 	int temp1 = dividend;
		 	int temp2 = 0;
		 	int firstdiv = 0;
		 	int period = 0;
			boolean isPeriod = true;
		 
		 //Получаем массив цифр для определения ближайшего делимого
		 for (int i = firstMin.length -1; i >= 0; i--)
		 {
			 firstMin[i] = temp1/10;
			 temp1 = temp1/10;
		 }
		 
		 //находим ближайшее делимое в массиве
		 for (int i = 0; i < firstMin.length; i++)
		 {
			 if (firstMin[i] >= divider)
			 {
				 firstdiv = firstMin[i];
				 break;
			 } 
		}
		//Выводим первую строку
		System.out.println("-"+dividend +"|"+ divider);
		
		//Задаем две строки, отдельно для целых, отдельно для десятых
		StringBuffer whole = new StringBuffer("");
		StringBuffer tenth = new StringBuffer("");
		
		//Проверяем тип деления, меньшее на большее или наоборот
		//находим наименьший делитель
		
		//Если ситуация стандартная, (делимое на много больше делителя)
		if (dividend > divider)
		{
			//Если наименьшее делимое и есть само делимое
			if (firstdiv == 0)
			{
				firstdiv = dividend;
			}
				//Получаем первое делимое число кратное делителю
				temp2 = divider * (firstdiv/divider);
				whole.append(String.valueOf(temp2/divider));
				//Пока что сохраняем в строку первое делимое число
				StringBuffer start = new StringBuffer(temp2 + "|");
				
				temp1 = firstdiv - temp2;
			
				period = firstdiv;
				int[]numbers = nextInd(firstdiv);
				int lastIndex = 0;
				boolean isWhole = true; 
				//Крутим цикл до ста найденых десятичных, или до конца деления
				for (int i = 0; i < 100; i++)
				{
					nums.add(" ---");
					if (temp1 < divider)
					{
						if (lastIndex != numbers.length){
						temp1 = Integer.parseInt(temp1+""+numbers[lastIndex]);
						lastIndex++;
						
						isWhole = true;
					}
						else if (temp1 != 0 && temp2 !=0)
					{
							while(temp1 < divider)temp1 = temp1*10;
						isWhole = false;
					} 	
				}
					if (temp1 == 0)
					{ 
						nums.add("0");
						break;
					}
					//Вылавливаем первое делимое
					if (isPeriod)
					{ 
						period = temp1;
						isPeriod = false;
					}
						
					nums.add("-"+String.valueOf(temp1));
					temp2 = divider*(temp1/divider);
					nums.add(" "+String.valueOf(temp2));
					//Определяем период
					if (temp1==period)tenth.append(".");
					temp1 = temp1 - temp2;		
					
				if (isWhole)
				{
					whole.append(String.valueOf(temp2/divider));
				} 
				else
				{		
					tenth.append(String.valueOf(temp2/divider));
				}
			}
				//Выводим все на консоль
			System.out.println(" "+start.toString() + whole+tenth);
			for (String i: nums)System.out.println(i);
	}
		else 
		{
		
		/* Если у нас производится деление меньшего на большее число
		 * мы заведомо знаем что делимое меньше 
		 * делителя, так что сразу умножаем его на десять*/
			temp1 = dividend*10;
			
		//Если одного перемножения недостаточно, повторяем
			while(temp1<divider)temp1=temp1*10;
			
			temp2 = divider*(temp1/divider);
			
		//В целых у нас по любому 0
			whole.append(0);
		
		//Пока что сохраняем в строку первое делимое число
			StringBuffer start = new StringBuffer(temp2 + "|");
		
		//Так что нам остается только высчитывать десятки
		for (int i = 0; i<100; i++)
		{
			nums.add(" ---");

			if (isPeriod){
				period = temp1;
				isPeriod = false;
			}
			
			if(temp1 == period)tenth.append(".");
			tenth.append(temp2/divider);
			temp1 = temp1-temp2;
			if (temp1 == 0)
			{
				nums.add("0");
				break;
			}
				while(temp1<divider)temp1=temp1*10;
			
			nums.add("-"+String.valueOf(temp1));
			temp2 = divider*(temp1/divider);
			nums.add(" "+String.valueOf(temp2));		
			
		}
			//Выводим на консоль
			System.out.println(start.toString() + whole.toString() + tenth.toString());
			for (String i: nums)System.out.println(i);	
		}
	}
 }