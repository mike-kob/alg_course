package strategies;


import java.util.Comparator;

public class CombSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {
	private static String strategyName = "Comb sort";

	@Override
	public T[] sortAsc(T[] ar) {
		int n = (int) (ar.length / 1.3);
		while (n >= 1) {
			for (int i = 0; i < ar.length - n; i++) {
				if (ar[i].compareTo(ar[i + n]) > 0) {
					T t = ar[i];
					ar[i] = ar[i + n];
					ar[i + n] = t;
				}
			}
			n = (int) (n / 1.3);
		}
		return ar;
	}

	@Override
	public T[] sortDesc(T[] ar) {
		int n = (int) (ar.length / 1.3);
		while (n >= 1) {
			for (int i = 0; i < ar.length - n; i++) {
				if (ar[i].compareTo(ar[i + n]) < 0) {
					T t = ar[i];
					ar[i] = ar[i + n];
					ar[i + n] = t;
				}
			}
			n = (int) (n / 1.3);
		}
		return ar;
	}

	@Override
	public T[] sortAsc(T[] ar, Comparator<T> c) {
		int n = (int) (ar.length / 1.3);
		while (n >= 1) {
			for (int i = 0; i < ar.length - n; i++) {
				if (c.compare(ar[i], ar[i + n]) > 0) {
					T t = ar[i];
					ar[i] = ar[i + n];
					ar[i + n] = t;
				}
			}
			n = (int) (n / 1.3);
		}
		return ar;
	}

	@Override
	public T[] sortDesc(T[] ar, Comparator<T> c) {
		int n = (int) (ar.length / 1.3);
		while (n >= 1) {
			for (int i = 0; i < ar.length - n; i++) {
				if (c.compare(ar[i], ar[i + n]) < 0) {
					T t = ar[i];
					ar[i] = ar[i + n];
					ar[i + n] = t;
				}
			}
			n = (int) (n / 1.3);
		}
		return ar;
	}

	@Override
	public String getStrategyName() {
		return strategyName;
	}

}
