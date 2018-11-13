

import java.util.NoSuchElementException;

public class Queue<T extends Comparable<T>> {
	private int maxSize = 0;
	private boolean areNullElementsAllowed = true;
	private List<T> queue;
	private int length;

	public Queue() {
	}

	public Queue(int maxSize, boolean areNullElementsAllowed) {
		this.maxSize = maxSize;
		this.areNullElementsAllowed = areNullElementsAllowed;
	}

	public boolean add(T item) {
		if (empty()) {
			queue = new List<>(item);
			length++;
			return true;
		}
		if (item == null && areNullElementsAllowed == false) {
			throw new NullPointerException();
		}

		if (length + 1 > maxSize && maxSize > 0) {
			throw new IllegalStateException();
		}
		queue.append(item);
		length++;
		return true;
	}

	public boolean empty() {
		return length == 0;
	}

	public T element() {
		if (empty()) {
			throw new NoSuchElementException();
		}
		return queue.getFirst();
	}

	public T peek() {
		if (empty()) {
			return null;
		}
		return queue.getFirst();
	}

	public boolean offer(T e) {
		if (empty()) {
			queue = new List<>(e);
			length++;
			return true;
		}
		if (e == null && areNullElementsAllowed == false) {
			throw new NullPointerException();
		}

		if (length > maxSize && maxSize > 0) {
			return false;
		}
		queue.append(e);
		length++;
		return true;
	}

	public T poll() {
		if (empty()) {
			return null;
		}
		T el = queue.getFirst();
		queue = queue.removeFirst();
		return el;
	}

	public T remove() {
		if (empty()) {
			throw new NoSuchElementException();
		}
		T el = queue.getFirst();
		queue = queue.removeFirst();
		return el;
	}

	public int search(T o) {
		int i = 0;
		for (T item : queue) {
			i++;
			if (item.equals(o)) {
				return i;
			}
		}
		return -1;
	}

	public String toString() {
		return queue.toString();
	}
}
