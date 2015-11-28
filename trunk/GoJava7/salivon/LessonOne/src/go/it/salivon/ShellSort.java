package go.it.salivon;

import go.it.main.Sort;
import java.util.Arrays;
import java.util.List;

public class ShellSort extends Sort {

    public static void main(String[] args) {
        ShellSort ss = new ShellSort();
        ss.show(ss.sort(Arrays.asList(1, 5, 20, 6, 3, 2, 7, 8, 3, 36, 5, 88, 0)));
    }

    public List<Integer> sort(List<Integer> a) {
        int N = a.size();
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a.get(j), a.get(j - h)); j -= h) {
                    exch(a, j, j - h);
                }
            }
            assert isHsorted(a, h);
            h /= 3;
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

    private boolean isHsorted(List<Integer> a, int h) {
        for (int i = h; i < a.size(); i++) {
            if (less(a.get(i), a.get(i - h))) {
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
