package distancebetweenmins;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class Distance {
	public static void main(String[] args) throws Exception{

        ArrayList<Integer> list = userInputDigits();
        for(Integer i : list){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
        ArrayList<Integer> miin = findMinsInArray(list);
        for(Integer r : miin){
            System.out.print(r + " ");
        }

        System.out.println();
        System.out.println();

        ArrayList<Integer> d = distance(miin);
        for(Integer f:d)
            System.out.print(f + " ");


    }

    private static ArrayList<Integer> userInputDigits() throws Exception {

        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String string = reader.readLine();
        String[] arrayOfStrings = string.split(" ");
        try{
            for(int i = 0; i < arrayOfStrings.length; i++){
                list.add(Integer.parseInt(arrayOfStrings[i]));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return list;
    }

	private static ArrayList<Integer> findMinsInArray(ArrayList<Integer> list){
        int min = list.get(0);
        ArrayList<Integer> listOfMins = new ArrayList<Integer>();
        for(int i = 0; i < list.size(); i++){
            if(min > list.get(i)){
                min = list.get(i);
            }
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == min)
                listOfMins.add(i);
        }

        if(listOfMins.size() < 2){
            int min2 = list.get(0);
            for(int i = 0; i < list.size(); i++){
                if(listOfMins.contains(i)){
                    break;
                }
                else{
                    if(min2 < list.get(i)){
                        min2 = list.get(i);
                    }
                }
            }

            for(int i = 0; i < list.size(); i++){
                if(list.get(i) == min2)
                    listOfMins.add(i);
            }
        }
        return listOfMins;
    }
    
    private static ArrayList<Integer> distance(ArrayList<Integer> list){
        ArrayList<Integer> dist = new ArrayList<Integer>();
        int difference = 0;
        for(int i = 0; i < list.size() - 1; i++){
            for(int j = 1; j < list.size(); j++){
                difference = Math.abs(list.get(i) - list.get(i + 1));
                dist.add(difference);
            }
        }
        return dist;
    }
}
