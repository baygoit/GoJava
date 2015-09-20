import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args) {
	int a[] = {8, 3, 6, 7, 1, 0};
	mergeSort(a, 0, a.length - 1);
	System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int []m, int p, int r) {
	if (p < r) {
	    int q = (p + r) / 2;
	    mergeSort(m, p, q);
	    mergeSort(m, q + 1, r);
	    merge(m, p, q, r);
	}
    }

    public static void merge(int m[], int p, int q, int r) {
	int n1 = q - p + 1;
	int n2 = r - q;
	int left[] = new int[n1 + 1];
	int right[] = new int[n2 + 1];
	left[left.length - 1] = Integer.MAX_VALUE;
	right[right.length - 1] = Integer.MAX_VALUE;
	for (int i = 0; i < n1; i++) {
	    left[i] = m[p + i];
	}
	for (int i = 0; i < n2; i++) {
	    right[i] = m[q + i + 1];
	}
	int i = 0;
	int j = 0;
	for (int k = p; k <= r; k++) {
	    if (left[i] <= right[j]) {
		m[k] = left[i];
		i++;
	    }
	    else {
		m[k] = right[j];
		j++;
	    }
	}
    }
}
