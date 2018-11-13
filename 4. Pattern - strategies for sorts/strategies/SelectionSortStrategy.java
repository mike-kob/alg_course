package strategies;


import java.util.Comparator;


public class SelectionSortStrategy<T extends Comparable<T>> implements SortStrategy<T>{

	static String strategyName = "Selection Sort";
	
	@Override
	public T[] sortAsc(T[] ar) {
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

	@Override
	public T[] sortDesc(T[] ar) {
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

	@Override
	public T[] sortAsc(T[] ar, Comparator<T> c) {
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

	@Override
	public T[] sortDesc(T[] ar, Comparator<T> c) {
		for (int i = 0; i < ar.length - 1; i++) {
			int maxN = i;
			for (int j = i + 1; j < ar.length; j++) {
				if (c.compare(ar[i], ar[maxN]) > 0) {
					maxN = j;
				}
			}
			T t = ar[i];
			ar[i] = ar[maxN];
			ar[maxN] = t;
		}
		return ar;
	}

	@Override
	public String getStrategyName() {
		return strategyName;
	}
	

}
