package strategies;


import java.util.Comparator;

public class QuickSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {
	private static String strategyName = "Quick sort";

	@Override
	public T[] sortAsc(T[] ar) {
		return recursiveQuickSort(ar, 0, ar.length - 1, true, null);
	}

	@Override
	public T[] sortDesc(T[] ar) {
		return recursiveQuickSort(ar, 0, ar.length - 1, false, null);
	}

	@Override
	public T[] sortAsc(T[] ar, Comparator<T> c) {
		return recursiveQuickSort(ar, 0, ar.length - 1, true, c);
	}

	@Override
	public T[] sortDesc(T[] ar, Comparator<T> c) {
		return recursiveQuickSort(ar, 0, ar.length - 1, false, c);
	}

	private T[] recursiveQuickSort(T ar[], int beginInd, int endInd, boolean ascending, Comparator<T> c) {
		if (beginInd < endInd) {
			int pivot = partition(ar, beginInd, endInd, ascending, c);

			recursiveQuickSort(ar, beginInd, pivot - 1, ascending, c);
			recursiveQuickSort(ar, pivot + 1, endInd, ascending, c);
		}
		return ar;
	}

	private int partition(T ar[], int beginInd, int endInd, boolean ascending, Comparator<T> c) {
		T pivot = ar[endInd];
		int i = (beginInd - 1); // index of smaller element
		for (int j = beginInd; j < endInd; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (c == null) {
				if ((ar[j].compareTo(pivot) < 0 && ascending) || (ar[j].compareTo(pivot) > 0 && !ascending)) {
					i++;

					// swap arr[i] and arr[j]
					T t = ar[i];
					ar[i] = ar[j];
					ar[j] = t;
				}
			} else {
				if ((c.compare(ar[j], pivot) < 0 && ascending) || (c.compare(ar[j], pivot) > 0 && !ascending)) {
					i++;

					// swap arr[i] and arr[j]
					T t = ar[i];
					ar[i] = ar[j];
					ar[j] = t;
				}
			}
		}

		// swap arr[i+1] and arr[endInd] (or pivot)
		T t = ar[i + 1];
		ar[i + 1] = ar[endInd];
		ar[endInd] = t;

		return i + 1;
	}

	@Override
	public String getStrategyName() {
		return strategyName;
	}
}
