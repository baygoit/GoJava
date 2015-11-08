package ua.scread.generator;

public class RandomArray implements GeneratorAlgorithm {
	
	@Override
	public Integer[] generate(int size) {
		Integer[] array = new Integer[size];
		//fill with random values from 0 to size*10
		for(int i = 0; i < array.length; i++){
			array[i] = (int)(Math.random()*(size*10 + 1));
		}
		return array;
	}
	@Override
	public String toString(){
		return RandomArray.class.getSimpleName();
	}
}
