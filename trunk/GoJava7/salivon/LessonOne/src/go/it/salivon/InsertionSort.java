package go.it.salivon;

import go.it.main.Sort;
import java.util.Arrays;
import java.util.List;

public class InsertionSort extends Sort {

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        is.show(is.sort(Arrays.asList(1, 5, 20, 6, 3, 2, 7, 8, 3, 36, 5, 88, 0)));
    }

    public List<Integer> sort(List<Integer> a) {
        int N = a.size();
        int exchanges = 0;
        for (int i = N - 1; i > 0; i--) {
            if (less(a.get(i), a.get(i - 1))) {
                exch(a, i, i - 1);
                exchanges++;
            }
        }
        if (exchanges == 0) {
            return a;
        }

        for (int i = 2; i < N; i++) {
            Comparable v = a.get(i);
            int j = i;
            while (less(v, a.get(j - 1))) {
                a.set(j, a.get(j - 1));
                j--;
            }
            a.set(j, (Integer) v);
        }

        assert isSorted(a);
        return a;
    }

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private void exch(List<Integer> a, int i, int j) {
        int swap = a.get(i);
        a.set(i, a.get(j));
        a.set(j, swap);
    }

    private boolean isSorted(List<Integer> a) {
        for (int i = 1; i < a.size(); i++) {
            if (less(a.get(i), a.get(i - 1))) {
                return false;
            }
        }
        return true;
    }

    private void show(List<Integer> a) {
        a.stream().forEach((a1) -> {
            System.out.print(a1 + " ");
        });
    }
}
