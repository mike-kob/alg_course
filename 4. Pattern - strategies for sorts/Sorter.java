

import java.util.Comparator;

import strategies.SortStrategy;

public class Sorter<T extends Comparable<T>> {
	
	SortStrategy<T> currentSortStrategy;

	
	public Sorter(SortStrategy<T> currentSortStrategy) {
		this.currentSortStrategy = currentSortStrategy;
	}


	public void setCurrentSortStrategy(SortStrategy<T> currentSortStrategy) {
		this.currentSortStrategy = currentSortStrategy;
	}
	
	
	public T[] sortAsc(T[] ar) {
		return currentSortStrategy.sortAsc(ar);
	}
	public T[] sortDesc(T[] ar) {
		return currentSortStrategy.sortDesc(ar);
	}
	
	public T[] sortAsc(T[] ar, Comparator<T> c) {
		return currentSortStrategy.sortAsc(ar, c);
	}
	public T[] sortDesc(T[] ar, Comparator<T> c) {
		return currentSortStrategy.sortDesc(ar, c);
	}
}
