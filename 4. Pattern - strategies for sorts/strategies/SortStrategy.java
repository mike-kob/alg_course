package strategies;


import java.util.Comparator;

public interface SortStrategy<T extends Comparable<T>> {
	static String strategyName = "s";
	
	public String getStrategyName();
	
	public T[] sortAsc(T[] ar);
	public T[] sortDesc(T[] ar);
	
	public T[] sortAsc(T[] ar, Comparator<T> c);
	public T[] sortDesc(T[] ar, Comparator<T> c);
	

}
