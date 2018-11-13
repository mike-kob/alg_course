package homework;

import java.util.Comparator;


public class SetProcessor<T> {

	public static<T extends Comparable<T>> List<T> union(List<T> A, List<T> B) {
		List<T> out = A.makeCopy();

		for (T i : B) {
			if(!A.contains(i)) {
				out.add(i);
			}
		}
		return out;
	}

	public static<T extends Comparable<T>> List<T> intersection(List<T> A, List<T> B) {
		List<T> out = A.makeCopy();

		for (T i : out) {
			if(!B.contains(i)) 
				out.remove(i);
		}
		return out;
	}

	public static<T extends Comparable<T>> List<T> difference(List<T> A, List<T> B) {
		List<T> out = A.makeCopy();

		if(equal(A, B)) {
			return new List<T>();
		}
		
		for (T i : B) {
			if(out.contains(i)) 
				out.remove(i);
		}
		return out;
	}

	public static <T extends Comparable<T>> boolean member(T x, List<T> B) {
		return B.contains(x);

	}

	public static<T extends Comparable<T>> void makeNull(List<T> A) {
		A.setData(null);
		A.setNext(null);
	}

	public static <T extends Comparable<T>> void insert(T x, List<T> B) {
		B.add(x);
	}

	public static <T extends Comparable<T>> void delete(T x, List<T> B) {
		B.remove(x);
	}
	
	@SuppressWarnings("rawtypes")
	public static void assign(List A,  List B) {
		List t = A.makeCopy();
		A = B;
		B = t;
	}

	public static <T extends Comparable<T>> T min(List<T> A, Comparator<T> c) {
		T min = A.getFirst();
		for(T el : A) {
			if(c.compare(el, min) < 0) min = el;
		}
		return min;
	}
	
	public static <T extends Comparable<T>> T min(List<T> A) {
		T min = A.getFirst();
		for(T el : A) {
			if(el.compareTo(min) < 0) min = el;
		}
		return min;
	}
	
	public static <T extends Comparable<T>> T max(List<T> A, Comparator<T> c) {
		T max = A.getFirst();
		for(T el : A) {
			if(c.compare(el, max) > 0) max = el;
		}
		return max;
	}
	
	public static <T extends Comparable<T>> T max(List<T> A) {
		T max = A.getFirst();
		for(T el : A) {
			if(el.compareTo(max) > 0) max = el;
		}
		return max;
	}

	public static<T extends Comparable<T>> boolean equal(List<T> A, List<T> B) {
		return A.toString().equals(B.toString());
	}
}
