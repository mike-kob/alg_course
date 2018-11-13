

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleList<T> implements Iterable<T> {
	
	
	@SuppressWarnings("unused")
	private static class Element<Q>  {	
		private Q data;	
		private Element<Q> prev;
		private Element<Q> next;
		
		
		public Element(Q data) {
			this.data = data;
		}
		
		public boolean equals(Element<Q> el) {
			if (el == null) {
				return false;
			}
			
			if ((el.data == null) && (this.data == null)) {
				return true;
			}
			
			if ((el.data == null) || (this.data == null)) {
				return false;
			}
			
			return (el.data.equals(this.data));
		}
	}
	
	private Element<T> head;
	private Element<T> tail;
	private Element<T> current;
	
	private int size;
	
	public DoubleList() {
		size = 0;
	}
	
	public DoubleList(T data) {
		this(new Element<>(data));
	}
	
	private DoubleList(Element<T> head) {
		this.head = head;
		this.current = head;
		this.tail = head;
		size = 1;
	}
	
	public DoubleList(DoubleList<T> list) {
		this.head = list.head;
		this.tail = list.tail;
		this.size = list.size;
	}
	
	public int getSize() {
		return size;
	}
	
	public void prepend(T data) {
		prepend(new Element<>(data));
	}
	
	private void prepend(Element<T> el) {
		head.prev = el;
		el.next = head;
		head = el;
		size++;
	}
	
	public void append(T data) {
		append(new Element<>(data));
	}
	
	private void append(Element<T> el) {
		if(head == null) {
			this.head = el;
			this.tail = el;
			size = 1;
			return;
		}
		tail.next = el;
		el.prev = tail;
		tail = el;
		size++;
	}	
	
	public void remove(int position) {
		if(size == 0 || position < 0 || position >= size) 
			throw new NoSuchElementException();
		
		if(position == 0) {
			head = head.next;
			head.prev = null;
		} else {
			Element<T> p = head;
			for(int i = 1; i < position - 1 && p.next != null; i++, p = p.next);
			
			Element<T> n = p.next.next;
			p.next = null;
			p.next = n;
			n.prev = p;
		}
		size--;
	}	
	
	public boolean contains(T data) {
		return contains(new Element<>(data));
	}
	
	private boolean contains(Element<T> el) {
		if (size == 0) {
			return false;
		}
		
		Element<T> p = head;
		
		while (p.next != null) {
			if (p.equals(el)) {
				return true;
			}
			
			p = p.next;
		}
		
		return p.equals(el);
	}
	
	public String toString() {
		if (size == 0) {
			return "List is empty";
		}
		
		StringBuilder res = new StringBuilder();
		Element<T> p = head;
		res.append(p.data);
		
		while (p.next != null) {
			res.append("; ");
			p = p.next;
			res.append(p.data);
		}
		
		return res.toString();
	}
	

	@Override
	public Iterator<T> iterator() {
		Iterator<T> it = new Iterator<T>() {

			private Element<T> cur = current;

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
