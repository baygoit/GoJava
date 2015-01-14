package ua.scread.generator;

/**
 * It is a class for generation different types of array.
 * <i>(it's a context in state machine pattern)</i>
 *  ArrayGenerator has such states(GeneratorAlgorithm):
 *  <b> SortedArray, SortedWithRandomEndArray, ReverseSortedArray, RandomArray</b>.
 * 
 * @author ScreaD
 *
 */
public class ArrayGenerator {
	//state of ArrayGenerator
	private GeneratorAlgorithm generator;
	
	public ArrayGenerator(){
		//default state is RandomArray, which generates array with random values
		generator = new RandomArray();
	}
	
	//generate Integer array
	public Integer[] generate(int size) {
		return generator.generate(size);
	}

	public GeneratorAlgorithm getGenerator() {
		return generator;
	}

	public void setGenerator(GeneratorAlgorithm generator) {
		this.generator = generator;
	}
}