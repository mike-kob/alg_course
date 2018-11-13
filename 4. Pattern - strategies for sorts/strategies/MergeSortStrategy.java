package strategies;


import java.util.Arrays;
import java.util.Comparator;

public class MergeSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {
	private static String strategyName = "Merge sort";
	
	@Override
	public T[] sortAsc(T[] ar) {
		return devideAndSort(ar, 0, ar.length - 1, true, null);
	}

	@Override
	public T[] sortDesc(T[] ar) {
		return devideAndSort(ar, 0, ar.length - 1, false, null);
	}

	@Override
	public T[] sortAsc(T[] ar, Comparator<T> c) {
		return devideAndSort(ar, 0, ar.length - 1, true, c);
	}

	@Override
	public T[] sortDesc(T[] ar, Comparator<T> c) {
		return devideAndSort(ar, 0, ar.length - 1, false, c);
	}

	private T[] devideAndSort(T ar[], int leftInd, int rightInd, boolean ascending, Comparator<T> c) {
		if (leftInd < rightInd) {
			// Find the middle point
			int middle = (leftInd + rightInd) / 2;

			// Sort first and second halves
			devideAndSort(ar, leftInd, middle, ascending, c);
			devideAndSort(ar, middle + 1, rightInd, ascending, c);

			// Merge the sorted halves
			merge(ar, leftInd, middle, rightInd, ascending, c);
		}
		return ar;
	}
	
	private void merge(T ar[], int leftInd, int middle, int rightInd, boolean ascending, Comparator<T> c) {
		// Find sizes of two subarrays to be merged
		int length1 = middle - leftInd + 1;
		int length2 = rightInd - middle;

		/* Create temp arrays */
		T L[] = Arrays.copyOf(ar, length1);
		T R[] = Arrays.copyOf(ar, length2);

		/* Copy data to temp arrays */
		for (int i = 0; i < length1; ++i)
			L[i] = ar[leftInd + i];
		for (int j = 0; j < length2; ++j)
			R[j] = ar[middle + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = leftInd;
		while (i < length1 && j < length2) {
			if (c == null) {
				if ((L[i].compareTo(R[j]) < 0 && ascending) || (!ascending && L[i].compareTo(R[j]) > 0)) {
					ar[k] = L[i];
					i++;
				} else {
					ar[k] = R[j];
					j++;
				}
				k++;
			} else {
				if ((c.compare(L[i], R[j]) < 0 && ascending) || (!ascending && c.compare(L[i], R[j]) > 0)) {
					ar[k] = L[i];
					i++;
				} else {
					ar[k] = R[j];
					j++;
				}
				k++;
			}

		}

		/* Copy remaining elements of L[] if any */
		while (i < length1) {
			ar[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < length2) {
			ar[k] = R[j];
			j++;
			k++;
		}
	}
	@Override
	public String getStrategyName() {
		return strategyName;
	}
}
