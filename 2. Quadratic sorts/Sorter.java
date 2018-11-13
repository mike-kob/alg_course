package practice;

import java.util.Comparator;

public class Sorter {

	// Bubble sort
	public static <T extends Comparable<T>> T[] bubbleSortAsc(T ar[]) {

		for (int j = 0; j < ar.length; j++) {
			for (int i = 0; i < ar.length - 1-j; i++) {
				if (ar[i].compareTo(ar[i + 1]) > 0) {
					T t = ar[i];
					ar[i] = ar[i + 1];
					ar[i + 1] = t;
				}
			}
		}
		return ar;
	}

	public static <T extends Comparable<T>> T[] bubbleSortDesc(T[] ar) {

		for (int j = 0; j < ar.length; j++) {
			for (int i = 0; i < ar.length - 1-j; i++) {
				if (ar[i].compareTo(ar[i + 1]) < 0) {
					T t = ar[i];
					ar[i] = ar[i + 1];
					ar[i + 1] = t;
				}
			}
		}
		return ar;
	}

	public static <T> T[] bubbleSortAsc(T ar[], Comparator<T> c) {

		for (int j = 0; j < ar.length; j++) {
			for (int i = 0; i < ar.length - 1-j; i++) {
				if (c.compare(ar[i], ar[i+1])>0) {
					T t = ar[i];
					ar[i] = ar[i + 1];
					ar[i + 1] = t;
				}
			}
		}
		return ar;
	}

	public static <T> T[] bubbleSortDesc(T[] ar,Comparator<T> c) {

		for (int j = 0; j < ar.length; j++) {
			for (int i = 0; i < ar.length - 1-j; i++) {
				if (c.compare(ar[i], ar[i+1]) < 0) {
					T t = ar[i];
					ar[i] = ar[i + 1];
					ar[i + 1] = t;
				}
			}
		}
		return ar;
	}
	
	
	
	// Selection sort
	public static <T extends Comparable<T>> T[] selectionSortAsc(T[] ar) {

		for (int i = 0; i < ar.length - 1; i++) {
			int minN = i;
			for (int j = i + 1; j < ar.length; j++) {
				if (ar[j].compareTo(ar[minN]) < 0) {
					minN = j;
				}
			}
			T t = ar[i];
			ar[i] = ar[minN];
			ar[minN] = t;
		}
		return ar;
	}

	public static <T extends Comparable<T>> T[] selectionSortDesc(T[] ar) {

		for (int i = 0; i < ar.length - 1; i++) {
			int maxN = i;
			for (int j = i + 1; j < ar.length; j++) {
				if (ar[j].compareTo(ar[maxN]) > 0) {
					maxN = j;
				}
			}
			T t = ar[i];
			ar[i] = ar[maxN];
			ar[maxN] = t;
		}
		return ar;
	}
	
	public static <T> T[] selectionSortAsc(T[] ar,Comparator<T> c) {

		for (int i = 0; i < ar.length - 1; i++) {
			int minN = i;
			for (int j = i + 1; j < ar.length; j++) {
				if (c.compare(ar[j], ar[minN]) < 0) {
					minN = j;
				}
			}
			T t = ar[i];
			ar[i] = ar[minN];
			ar[minN] = t;
		}
		return ar;
	}

	public static <T> T[] selectionSortDesc(T[] ar,Comparator<T> c) {

		for (int i = 0; i < ar.length - 1; i++) {
			int maxN = i;
			for (int j = i + 1; j < ar.length; j++) {
				if (c.compare(ar[i], ar[maxN])> 0) {
					maxN = j;
				}
			}
			T t = ar[i];
			ar[i] = ar[maxN];
			ar[maxN] = t;
		}
		return ar;
	}

}
