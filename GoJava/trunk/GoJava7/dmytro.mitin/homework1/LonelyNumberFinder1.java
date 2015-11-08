/**
 * Created by Dmytro on 29.10.2015.
 */

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class LonelyNumberFinder1 {
    public static void main(String[] args) {
        LonelyNumberFinder finder = new LonelyNumberFinder();
        LonelyNumberFinder1 finder1 = new LonelyNumberFinder1();
        int[] numbers = {1, 2, 3, 1, 2, 3, 1, 4, 4};
        System.out.println(finder.findLonelyNumber(numbers));
        System.out.println(finder.findLonelyNumber1(numbers));
        System.out.println(finder1.findLonelyNumber2(numbers));
    }

    public int findLonelyNumber2(int[] numbers) {
        LonelyNumberFinder1 finder = new LonelyNumberFinder1();
        Stream<Integer> stream = Arrays.stream(numbers).sorted().boxed();
        Stream<Integer> stream1 = Arrays.stream(numbers).sorted().boxed().skip(1);
        Stream<Integer> stream2 = Arrays.stream(numbers).sorted().boxed().skip(2);
        return finder.zip3(stream, stream1, stream2)
                .filter(triple -> triple.first == triple.second && triple.second == triple.third)
                .findAny().get().first;
    }

    public <A, B, C> Stream<Triple<A,B,C>> zip3(Stream<? extends A> a,
                                                Stream<? extends B> b,
                                                Stream<? extends C> c) {
        @SuppressWarnings("unchecked")
        Spliterator<A> aSpliterator = (Spliterator<A>) Objects.requireNonNull(a).spliterator();
        @SuppressWarnings("unchecked")
        Spliterator<B> bSpliterator = (Spliterator<B>) Objects.requireNonNull(b).spliterator();
        @SuppressWarnings("unchecked")
        Spliterator<C> cSpliterator = (Spliterator<C>) Objects.requireNonNull(c).spliterator();


        // Zipping looses DISTINCT and SORTED characteristics
        int all = aSpliterator.characteristics() & bSpliterator.characteristics() & cSpliterator.characteristics() &
                ~(Spliterator.DISTINCT | Spliterator.SORTED);
        int characteristics = all;

        long zipSize = ((characteristics & Spliterator.SIZED) != 0)
                ? Math.min(Math.min(aSpliterator.getExactSizeIfKnown(),
                        bSpliterator.getExactSizeIfKnown()),
                cSpliterator.getExactSizeIfKnown())
                : -1;

        Iterator<A> aIterator = Spliterators.iterator(aSpliterator);
        Iterator<B> bIterator = Spliterators.iterator(bSpliterator);
        Iterator<C> cIterator = Spliterators.iterator(cSpliterator);
        Iterator<Triple<A,B,C>> dIterator = new Iterator<Triple<A,B,C>>() {
            @Override
            public boolean hasNext() {
                return aIterator.hasNext() && bIterator.hasNext() && cIterator.hasNext();
            }

            @Override
            public Triple<A,B,C> next() {
                return new Triple<A,B,C>(aIterator.next(), bIterator.next(), cIterator.next());
            }
        };

        Spliterator<Triple<A,B,C>> split = Spliterators.spliterator(dIterator, zipSize, characteristics);
        return (a.isParallel() || b.isParallel() || c.isParallel())
                ? StreamSupport.stream(split, true)
                : StreamSupport.stream(split, false);
    }

    public class Triple<A,B,C> {
        public A first;

        public B second;

        public C third;

        public Triple(A first, B second, C third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ", " + third + ')';
        }
    }
}
