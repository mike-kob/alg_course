package strategies;


import java.util.Comparator;

public class HeapSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {
	private static String strategyName = "Comb sort";

	@Override
	public T[] sortAsc(T[] ar) {
		// Build heap (rearrange array)
		for (int i = ar.length / 2 - 1; i >= 0; i--)
			heapify(ar, ar.length, i, true, null);

		// One by one extract an element from heap
		for (int i = ar.length - 1; i >= 0; i--) {
			// Move current root to end
			T t = ar[0];
			ar[0] = ar[i];
			ar[i] = t;

			// call max heapify on the reduced heap
			heapify(ar, i, 0, true, null);
		}
		return ar;
	}

	@Override
	public T[] sortDesc(T[] ar) {

		for (int i = ar.length / 2 - 1; i >= 0; i--)
			heapify(ar, ar.length, i, false, null);

		// One by one extract an element from heap
		for (int i = ar.length - 1; i >= 0; i--) {
			// Move current root to end
			T t = ar[0];
			ar[0] = ar[i];
			ar[i] = t;

			// call min heapify on the reduced heap
			heapify(ar, i, 0, false, null);
		}
		return ar;
	}

	@Override
	public T[] sortAsc(T[] ar, Comparator<T> c) {
		// Build heap (rearrange array)
		for (int i = ar.length / 2 - 1; i >= 0; i--)
			heapify(ar, ar.length, i, true, c);

		// One by one extract an element from heap
		for (int i = ar.length - 1; i >= 0; i--) {
			// Move current root to end
			T t = ar[0];
			ar[0] = ar[i];
			ar[i] = t;

			// call min heapify on the reduced heap
			heapify(ar, i, 0, true, c);
		}
		return ar;
	}

	@Override
	public T[] sortDesc(T[] ar, Comparator<T> c) {
		// Build heap (rearrange array)
		for (int i = ar.length / 2 - 1; i >= 0; i--)
			heapify(ar, ar.length, i, false, c);

		// One by one extract an element from heap
		for (int i = ar.length - 1; i >= 0; i--) {
			// Move current root to end
			T t = ar[0];
			ar[0] = ar[i];
			ar[i] = t;

			// call min heapify on the reduced heap
			heapify(ar, i, 0, false, c);
		}
		return ar;
	}

	private T[] heapify(T ar[], int n, int i, boolean ascending, Comparator<T> c) {
		// To heapify a subtree rooted with node i which is
		// an index in arr[]. n is size of heap
		int max_or_min = i; // Initialize max or min as root
		int leftSubTree = 2 * i + 1; // left = 2*i + 1
		int rightSubTree = 2 * i; // right = 2*i + 2

		// If left child is larger than root
		if (c == null) {
			if (ascending) {
				if (leftSubTree < n && ar[leftSubTree].compareTo(ar[max_or_min]) > 0)
					max_or_min = leftSubTree;

				// If right child is larger than max_or_min so far
				if (rightSubTree < n && ar[rightSubTree].compareTo(ar[max_or_min]) > 0)
					max_or_min = rightSubTree;
			} else {
				if (leftSubTree < n && ar[leftSubTree].compareTo(ar[max_or_min]) < 0)
					max_or_min = leftSubTree;

				// If right child is larger than max_or_min so far
				if (rightSubTree < n && ar[rightSubTree].compareTo(ar[max_or_min]) < 0)
					max_or_min = rightSubTree;
			}
		} else {
			if (ascending) {
				if (leftSubTree < n && c.compare(ar[leftSubTree], ar[max_or_min]) > 0)
					max_or_min = leftSubTree;

				// If right child is larger than max_or_min so far
				if (rightSubTree < n && c.compare(ar[rightSubTree], ar[max_or_min]) > 0)
					max_or_min = rightSubTree;
			} else {
				if (leftSubTree < n && c.compare(ar[leftSubTree], ar[max_or_min]) < 0)
					max_or_min = leftSubTree;

				// If right child is larger than max_or_min so far
				if (rightSubTree < n && c.compare(ar[rightSubTree], ar[max_or_min]) < 0)
					max_or_min = rightSubTree;
			}
		}
		// If max_or_min is not root
		if (max_or_min != i) {
			T t = ar[i];
			ar[i] = ar[max_or_min];
			ar[max_or_min] = t;

			// Recursively heapify the affected sub-tree
			heapify(ar, n, max_or_min, ascending, c);
		}

		return ar;
	}

	@Override
	public String getStrategyName() {
		return strategyName;
	}
}
