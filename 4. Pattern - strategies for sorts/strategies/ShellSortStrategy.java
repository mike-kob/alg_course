package strategies;


import java.util.Comparator;


public class ShellSortStrategy<T extends Comparable<T>> implements SortStrategy<T>{
	private static String strategyName = "Shell sort";
	
	@Override
	public T[] sortAsc(T[] ar) {
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

	@Override
	public T[] sortDesc(T[] ar) {
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

	@Override
	public T[] sortAsc(T[] ar, Comparator<T> c) {
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

	@Override
	public T[] sortDesc(T[] ar, Comparator<T> c) {
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
	@Override
	public String getStrategyName() {
		return strategyName;
	}

}
