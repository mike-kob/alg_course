

import java.util.Arrays;
import java.util.Comparator;

public class Sorter {

	// Last practice part -------------------------------------------
	// Heap sort

	public static <T extends Comparable<T>> T[] heapSortAsc(T ar[]) {
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

	public static <T extends Comparable<T>> T[] heapSortDesc(T ar[]) {
		// Build heap (rearrange array)
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
	
	public static <T extends Comparable<T>> T[] heapSortAsc(T ar[], Comparator<T> c) {
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
	
	public static <T extends Comparable<T>> T[] heapSortDesc(T ar[], Comparator<T> c) {
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

	private static <T extends Comparable<T>> T[] heapify(T ar[], int n, int i, boolean ascending, Comparator<T> c) {
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
			heapify(ar, n, max_or_min, ascending,c);
		}

		return ar;
	}

	// Quick sort

	public static <T extends Comparable<T>> T[] quickSortAsc(T ar[]) {
		return recursiveQuickSort(ar, 0, ar.length - 1, true, null);
	}

	public static <T extends Comparable<T>> T[] quickSortDesc(T ar[]) {
		return recursiveQuickSort(ar, 0, ar.length - 1, false, null);
	}

	public static <T extends Comparable<T>> T[] quickSortAsc(T ar[], Comparator<T> c) {
		return recursiveQuickSort(ar, 0, ar.length - 1, true, c);
	}

	public static <T extends Comparable<T>> T[] quickSortDesc(T ar[], Comparator<T> c) {
		return recursiveQuickSort(ar, 0, ar.length - 1, false, c);
	}

	private static <T extends Comparable<T>> T[] recursiveQuickSort(T ar[], int beginInd, int endInd, boolean ascending,
			Comparator<T> c) {
		if (beginInd < endInd) {
			int pivot = partition(ar, beginInd, endInd, ascending, c);

			recursiveQuickSort(ar, beginInd, pivot - 1, ascending, c);
			recursiveQuickSort(ar, pivot + 1, endInd, ascending, c);
		}
		return ar;
	}

	private static <T extends Comparable<T>> int partition(T ar[], int beginInd, int endInd, boolean ascending,
			Comparator<T> c) {
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

	// Merge sort

	public static <T extends Comparable<T>> T[] mergeSortAsc(T ar[]) {
		return devideAndSort(ar, 0, ar.length - 1, true, null);
	}

	public static <T extends Comparable<T>> T[] mergeSortDesc(T ar[]) {
		return devideAndSort(ar, 0, ar.length - 1, false, null);
	}

	public static <T extends Comparable<T>> T[] mergeSortAsc(T ar[], Comparator<T> c) {
		return devideAndSort(ar, 0, ar.length - 1, true, c);
	}

	public static <T extends Comparable<T>> T[] mergeSortDesc(T ar[], Comparator<T> c) {
		return devideAndSort(ar, 0, ar.length - 1, false, c);
	}

	private static <T extends Comparable<T>> T[] devideAndSort(T ar[], int leftInd, int rightInd, boolean ascending,
			Comparator<T> c) {
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

	private static <T extends Comparable<T>> void merge(T ar[], int leftInd, int middle, int rightInd,
			boolean ascending, Comparator<T> c) {
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

}
