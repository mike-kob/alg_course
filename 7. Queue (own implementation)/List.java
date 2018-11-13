

import java.util.ArrayList;
import java.util.Iterator;

public class List<T extends Comparable<T>> implements Iterable<T> {
	private T data;
	private List<T> current = this;
	private List<T> next;
	public int length;

	public List() {

	}

	public List(T data) {
		this.data = data;
	}

	public T getFirst() {
		return data;
	}

	public void add(T x) {
		List<T> l = this;

		if (l.data.compareTo(x) > 0) {
			List<T> t = this.makeCopy();
			this.data = x;
			this.next = t;
			length++;
			return;
		}

		while (l.next != null) {
			if (l.next.data.compareTo(x) > 0) {
				List<T> t = l.next;
				l.next = new List<T>(x);
				l.next.next = t;
				length++;
				return;
			} else {
				l = l.next;
			}
		}
		length++;
		l.next = new List<T>(x);
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setNext(List<T> next) {
		this.next = next;
	}

	public void remove(T x) {
		List<T> l = this;


		if (this.data.equals(x)) {
			this.data = l.next.data;
			this.next = l.next.next;
			return;
		
		}
		while (l.next != null) {
			if (l.next.data.equals(x)) {
				l.next = l.next.next;
				return;
			} else {
				l = l.next;
			}
		}
		l.next = null;
	}
	
	public List<T> removeFirst() {
		return next;
	}

	public boolean contains(T x) {
		List<T> l = this;

		while (l != null) {
			if (l.data.equals(x))
				return true;
			l = l.next;
		}
		return false;
	}

	public List<T> makeCopy() {
		List<T> out = new List<T>(this.data);
		if (this.next != null) {
			for (T i : this.next) {
				out.append(i);
			}
		}
		return out;

	}

	public void append(List<T> el) {
		List<T> l = this;

		while (l.next != null) {
			l = l.next;
		}

		l.next = el;
		length++;
	}

	public void append(T data) {
		append(new List<T>(data));
	}
	
	public List<T> prepend(List<T> el) {
		el.next = this;
		length++;
		return el;
	}
	
	public List<T> prepend(T data) {
		return prepend(new List<T>(data));
	}
	

	@Override
	public String toString() {
		ArrayList<T> ar = new ArrayList<>();
		List<T> p = this;
		ar.add(p.data);

		while (p.next != null) {
			p = p.next;
			ar.add(p.data);
		}

		return ar.toString();
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> it = new Iterator<T>() {

			private List<T> cur = current;

			@Override
			public boolean hasNext() {
				if (cur == null) {
					return false;
				}

				return true;
			}

			@Override
			public T next() {
				T data = cur.data;
				cur = cur.next;
				return data;
			}
		};
		return it;
	}
}
