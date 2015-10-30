import java.util.Arrays;
import java.util.function.Function;

/**
 * Created by Dmytro on 22.10.2015.
 */
public class LonelyNumberFinder {
    public static void main(String[] args) {
        LonelyNumberFinder finder = new LonelyNumberFinder();
        int[] numbers = {1, 2, 3, 1, 2, 3, 1, 4, 4};
        System.out.println(finder.findLonelyNumber(numbers));
        System.out.println(finder.findLonelyNumber1(numbers));
    }

    public int findLonelyNumber(int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i] == numbers[i + 1] && numbers[i + 1] == numbers[i + 2]) {
                return numbers[i];
            }
        }
        throw new IllegalArgumentException("No number repeated thrice in the array!");
    }

    public int findLonelyNumber1(int[] numbers) {
        class Triple {
            public Integer first;
            public Integer second;
            public Integer third;

            public Triple(Integer first, Integer second, Integer third) {
                this.first = first;
                this.second = second;
                this.third = third;
            }
        }

        return Arrays.stream(numbers).sorted().boxed().map(
                new Function<Integer, Triple>() {
                    Integer beforePrevious;
                    Integer previous;

                    @Override
                    public Triple apply(Integer number) {
                        Triple triple = null;
                        if (beforePrevious != null && previous != null) {
                            triple = new Triple(beforePrevious, previous, number);
                        }
                        beforePrevious = previous;
                        previous = number;
                        return triple;
                    }
                }).skip(2).filter(triple -> triple.first == triple.second && triple.second == triple.third).findAny().get().first;
    }

}
