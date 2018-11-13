package strategies;


import java.util.Comparator;

public class BubbleSortStrategy<T extends Comparable<T>> implements SortStrategy<T>{
	private static String strategyName = "Bubble sort";
	
	@Override
	public T[] sortAsc(T[] ar) {
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

	@Override
	public T[] sortDesc(T[] ar) {
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

	@Override
	public T[] sortAsc(T[] ar, Comparator<T> c) {
		for (int j = 0; j < ar.length; j++) {
			for (int i = 0; i < ar.length - 1; i++) {
				if (c.compare(ar[i], ar[i + 1]) > 0) {
					T t = ar[i];
					ar[i] = ar[i + 1];
					ar[i + 1] = t;
				}
			}
		}
		return ar;
	}

	@Override
	public T[] sortDesc(T[] ar, Comparator<T> c) {
		for (int j = 0; j < ar.length; j++) {
			for (int i = 0; i < ar.length - 1; i++) {
				if (c.compare(ar[i], ar[i + 1]) < 0) {
					T t = ar[i];
					ar[i] = ar[i + 1];
					ar[i + 1] = t;
				}
			}
		}
		return ar;
	}
	@Override
	public String getStrategyName() {
		return strategyName;
	}

}
