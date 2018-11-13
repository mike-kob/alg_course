

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class ArrayTree<T> implements MyTree<T> {

	private Object[] data;
	private int size;

	public ArrayTree(final T rootElement) {
		this(rootElement, 0);
	}

	public ArrayTree(final T rootElement, final int n) {
		if (null == rootElement) {
			throw new NullPointerException();
		}

		data = new Object[(int) Math.pow(2, n + 1) - 1];
		data[0] = rootElement;
		size = 1;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	public T[] getData() {
		return (T[]) Arrays.copyOf(data, data.length);
	}

	@Override
	public void addValue(final T newValue, final T fatherValue, final boolean isAddingAsLeftSon) {
		if (null == newValue) {
			throw new NullPointerException();
		}

		if (getIndexOfElement(newValue) != -1) {
			throw new SecurityException();
		}

		int indexOfFather = getIndexOfElement(fatherValue);
		if (indexOfFather == -1) {
			throw new NoSuchElementException();
		}

		if (2 * indexOfFather + 1 >= data.length) {
			Object[] newData = Arrays.copyOf(data, 2 * data.length + 1);
			data = newData;
		}

		if (isAddingAsLeftSon) {
			if (null == data[2 * indexOfFather + 1]) {
				data[2 * indexOfFather + 1] = newValue;
				size++;
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			if (null == data[2 * indexOfFather + 2]) {
				data[2 * indexOfFather + 2] = newValue;
				size++;
			} else {
				throw new IllegalArgumentException();
			}
		}
	}

	@SuppressWarnings("unchecked")
	private int getIndexOfElement(final T element) {
		return IntStream.range(0, data.length).filter(i -> ((null != data[i]) && ((T) data[i]).equals(element)))
				.findFirst().orElse(-1);
	}

	@Override
	public String toString() {
		return subtreeToString(0);
	}

	private String subtreeToString(final int rootIndex) {
		if (rootIndex >= data.length) {
			return "_";
		}
		return String.format("( %s ( %s , %s )", (null == data[rootIndex]) ? "NULL" : data[rootIndex].toString(),
				subtreeToString(2 * rootIndex + 1), subtreeToString(2 * rootIndex + 2));
	}

	@Override
	@SuppressWarnings("unchecked")
	public void removeValue(T value) {
		if (value == null) {
			throw new NullPointerException();
		}
		int index = getIndexOfElement(value);

		if (index == -1) {
			throw new NoSuchElementException();
		}

		if (2 * index + 2 > size || (data[2 * index + 1] == null && data[2 * index + 2] == null)) {
			data[index] = null;
			return;
		}

		if (data[2 * index + 1] != null && data[2 * index + 2] == null) {
			moveValue((T) data[2 * index + 1], (T) data[(index - 1) / 2], true);
			return;
		}

		if (data[2 * index + 2] != null && data[2 * index + 1] == null) {
			moveValue((T) data[2 * index + 2], (T) data[(index - 2) / 2], false);
			return;
		}

		T copy = (T) data[2 * index + 1];
		removeValue(copy);
		data[index] = copy;

		int k = 2 * index + 1;
		while (2 * k + 1 < size) {
			if (data[k] == null) {
				break;
			} else {
				k = 2 * k + 1;
			}
		}

		moveValue((T) data[2 * index + 2], (T) data[(k - 1) / 2], true);
	}

	@SuppressWarnings("unchecked")
	public void moveValue(T value, T parent, boolean addAsLeftSon) {
		int index = getIndexOfElement(value);
		int parentIndex = getIndexOfElement(parent);

		data[index] = null;
		try {
			addValue(value, parent, addAsLeftSon);
		} catch (Exception e) {
			if (addAsLeftSon) {
				data[2 * parentIndex + 1] = null;
			} else {
				data[2 * parentIndex + 2] = null;
			}
			addValue(value, parent, addAsLeftSon);
		}
		if (2 * index + 1 < size && data[2 * index + 1] != null) {
			moveValue((T) data[2 * index + 1], value, true);
		}
		if (2 * index + 2 < size && data[2 * index + 2] != null) {
			moveValue((T) data[2 * index + 2], value, false);
		}

	}

}
