package homework;

import java.util.Comparator;

public class Sorter {
	// Homework part---------------------------------------------------------
			//Insertion sort
	public static <T extends Comparable<T>> T[] insertionSortAsc(T ar[]) {
		for(int i = 1;i<ar.length;i++) {
			int loop = i;
			while(i>0&&ar[i-1].compareTo(ar[i])>0) {
				T t = ar[i-1];
				ar[i-1] = ar[i];
				ar[i] = t;
				i--;
			}
			i=loop;
		}
		return ar;
		
	}
	
	public static <T extends Comparable<T>> T[] insertionSortDesc(T ar[]) {
		for(int i = 1;i<ar.length;i++) {
			int loop = i;
			while(i>0&&ar[i-1].compareTo(ar[i])<0) {
				T t = ar[i-1];
				ar[i-1] = ar[i];
				ar[i] = t;
				i--;
			}
			i=loop;
		}
		return ar;
		
	}
	
	public static <T> T[] insertionSortAsc(T ar[], Comparator<T> c) {
		for(int i = 1;i<ar.length;i++) {
			int loop = i;
			while(i>0&&c.compare(ar[i-1], ar[i])>0) {
				T t = ar[i-1];
				ar[i-1] = ar[i];
				ar[i] = t;
				i--;
			}
			i=loop;
		}
		return ar;
		
	}
	
	public static <T> T[] insertionSortDesc(T ar[], Comparator<T> c) {
		for(int i = 1;i<ar.length;i++) {
			int loop = i;
			while(i>0&&c.compare(ar[i-1], ar[i])<0) {
				T t = ar[i-1];
				ar[i-1] = ar[i];
				ar[i] = t;
				i--;
			}
			i=loop;
		}
		return ar;
		
	}
	
	
			//Comb sort
	public static <T extends Comparable<T>> T[] combSortAsc(T ar[]) {
		int n = (int)(ar.length/1.3);
		while(n>=1) {
			for(int i = 0;i<ar.length-n;i++) {
				if(ar[i].compareTo(ar[i+n])>0) {
					T t = ar[i];
					ar[i]=ar[i+n];
					ar[i+n]=t;
				}
			}
			n=(int)(n/1.3);
		}
	return ar;
	}
	
	public static <T extends Comparable<T>> T[] combSortDesc(T ar[]) {
		int n = (int)(ar.length/1.3);
		while(n>=1) {
			for(int i = 0;i<ar.length-n;i++) {
				if(ar[i].compareTo(ar[i+n])<0) {
					T t = ar[i];
					ar[i]=ar[i+n];
					ar[i+n]=t;
				}
			}
			n=(int)(n/1.3);
		}
	return ar;
	}
	
	public static <T> T[] combSortAsc(T ar[], Comparator<T> c) {
		int n = (int)(ar.length/1.3);
		while(n>=1) {
			for(int i = 0;i<ar.length-n;i++) {
				if(c.compare(ar[i], ar[i+n])>0) {
					T t = ar[i];
					ar[i]=ar[i+n];
					ar[i+n]=t;
				}
			}
			n=(int)(n/1.3);
		}
	return ar;
	}
	
	public static <T> T[] combSortDesc(T ar[], Comparator<T> c) {
		int n = (int)(ar.length/1.3);
		while(n>=1) {
			for(int i = 0;i<ar.length-n;i++) {
				if(c.compare(ar[i], ar[i+n])<0) {
					T t = ar[i];
					ar[i]=ar[i+n];
					ar[i+n]=t;
				}
			}
			n=(int)(n/1.3);
		}
	return ar;
	}
	
	
			//Shell sort
	public static <T extends Comparable<T>> T[] shellSortAsc(T ar[]) {
		for (int gap = ar.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < ar.length; i += 1) {
				T t = ar[i];
				int j;
				
				for (j = i; j >= gap && ar[j - gap].compareTo(t) > 0; j -= gap) {
					ar[j] = ar[j - gap];
				}
				
				ar[j] = t;
			}
		}
		return ar;
	}
	
	public static <T extends Comparable<T>> T[] shellSortDesc(T ar[]) {
		for (int gap = ar.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < ar.length; i += 1) {
				T t = ar[i];
				int j;
				
				for (j = i; j >= gap && ar[j - gap].compareTo(t) < 0; j -= gap) {
					ar[j] = ar[j - gap];
				}
				
				ar[j] = t;
			}
		}
		return ar;
	}
			
	public static <T> T[] shellSortAsc(T ar[], Comparator<T> c) {
		for (int gap = ar.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < ar.length; i += 1) {
				T t = ar[i];
				int j;
				
				for (j = i; j >= gap && c.compare(ar[j - gap], t) > 0; j -= gap) {
					ar[j] = ar[j - gap];
				}
				
				ar[j] = t;
			}
		}
		return ar;
	}
	
	public static <T> T[] shellSortDesc(T ar[], Comparator<T> c) {
		for (int gap = ar.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < ar.length; i += 1) {
				T t = ar[i];
				int j;
				
				for (j = i; j >= gap && c.compare(ar[j - gap], t) < 0; j -= gap) {
					ar[j] = ar[j - gap];
				}
				
				ar[j] = t;
			}
		}
		return ar;
	}

	
	// Practice paart--------------------------------------------------------
	
			//Bubble sort
	public static <T extends Comparable<T>> T[] bubbleSortAsc(T ar[]) {

		for (int j = 0; j < ar.length; j++) {
			for (int i = 0; i < ar.length - 1; i++) {
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
			for (int i = 0; i < ar.length - 1; i++) {
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
			for (int i = 0; i < ar.length - 1; i++) {
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
			for (int i = 0; i < ar.length - 1; i++) {
				if (c.compare(ar[i], ar[i+1]) < 0) {
					T t = ar[i];
					ar[i] = ar[i + 1];
					ar[i + 1] = t;
				}
			}
		}
		return ar;
	}
	
	
			//Selection sort
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
