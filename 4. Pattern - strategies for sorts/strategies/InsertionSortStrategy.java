package strategies;


import java.util.Comparator;

public class InsertionSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {
	private static String strategyName = "Inserion sort";
	
	@Override
	public T[] sortAsc(T[] ar) {
		for (int i = 1; i < ar.length; i++) {
			int loop = i;
			while (i > 0 && ar[i - 1].compareTo(ar[i]) > 0) {
				T t = ar[i - 1];
				ar[i - 1] = ar[i];
				ar[i] = t;
				i--;
			}
			i = loop;
		}
		return ar;
	}

	@Override
	public T[] sortDesc(T[] ar) {
		for (int i = 1; i < ar.length; i++) {
			int loop = i;
			while (i > 0 && ar[i - 1].compareTo(ar[i]) < 0) {
				T t = ar[i - 1];
				ar[i - 1] = ar[i];
				ar[i] = t;
				i--;
			}
			i = loop;
		}
		return ar;
	}

	@Override
	public T[] sortAsc(T[] ar, Comparator<T> c) {
		for (int i = 1; i < ar.length; i++) {
			int loop = i;
			while (i > 0 && c.compare(ar[i - 1], ar[i]) > 0) {
				T t = ar[i - 1];
				ar[i - 1] = ar[i];
				ar[i] = t;
				i--;
			}
			i = loop;
		}
		return ar;
	}

	@Override
	public T[] sortDesc(T[] ar, Comparator<T> c) {
		for (int i = 1; i < ar.length; i++) {
			int loop = i;
			while (i > 0 && c.compare(ar[i - 1], ar[i]) < 0) {
				T t = ar[i - 1];
				ar[i - 1] = ar[i];
				ar[i] = t;
				i--;
			}
			i = loop;
		}
		return ar;
	}

	@Override
	public String getStrategyName() {
		return strategyName;
	}
}
