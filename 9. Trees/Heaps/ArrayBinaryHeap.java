package practice;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayBinaryHeap<T extends Comparable<T>> {

    private Object[] array;
    private int size;
    private boolean isMax;

    public ArrayBinaryHeap(boolean isMax) {
        this.isMax = isMax;
        this.array = new Object[1];
        this.size = 0;

    }


    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void add(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (array[0] == null) {
            array[0] = element;
            size++;
            return;
        }
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length + 1);
        }
        array[size] = element;
        size++;

        if (isMax) {
        	maxHeapify(size - 1);
        } else {
            minHeapify(size - 1);
        }

    }

    @SuppressWarnings("unchecked")
	public T peek() {
        return (T) array[0];
    }

    public boolean contains(T element) {
        for (Object i : array) {
            if (i.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
	public T remove() {
        if (array[0] == null) {
            throw new NoSuchElementException();
        }
        T t = (T) array[0];
        swap(0, size - 1);
        size--;
        array = Arrays.copyOf(array, size);

        if (isMax) {
            reverseMaxHeapify(0);
        } else {
            reverseMinHeapify(0);
        }

        return t;
    }


    @SuppressWarnings("unchecked")
	private void reverseMinHeapify(int root) {
        if (2 * root + 2 >= size) {
            return;
        }

        if (((T) array[root]).compareTo((T) array[2 * root + 1]) > 0) {
            swap(root, 2 * root + 1);
            reverseMinHeapify(2 * root + 1);
            return;
        }

        if (((T) array[root]).compareTo((T) array[2 * root + 2]) > 0) {
            swap(root, 2 * root + 2);
            reverseMinHeapify(2 * root + 2);
        }
    }

    @SuppressWarnings("unchecked")
	private void reverseMaxHeapify(int root) {
        if (2 * root + 2 >= size) {
            return;
        }

        if (((T) array[root]).compareTo((T) array[2 * root + 1]) < 0) {
            swap(root, 2 * root + 1);
            reverseMaxHeapify(2 * root + 1);
        }

        if (((T) array[root]).compareTo((T) array[2 * root + 2]) < 0) {
            swap(root, 2 * root + 2);
            reverseMaxHeapify(2 * root + 2);
        }
    }

    @SuppressWarnings("unchecked")
    private void maxHeapify(int last) {
        if (last == 0) {
            return;
        }
        if (last == 1) {
            if (((T) array[last / 2]).compareTo((T) array[last]) < 0) {
                swap(last / 2, last);
            }
            return;
        }
        if (((T) array[last / 2 ]).compareTo((T) array[last]) < 0) {
            swap(last / 2, last);
            maxHeapify(last / 2 );
        }
    }

    @SuppressWarnings("unchecked")
    private void minHeapify(int last) {
        if (last == 0) {
            return;
        }
        if (last == 1) {
            if (((T) array[last / 2]).compareTo((T) array[last]) > 0) {
                swap(last / 2, last);
            }
            return;
        }
        if (((T) array[last / 2]).compareTo((T) array[last]) > 0) {
            swap(last / 2, last);
            minHeapify(last / 2);
        }
    }

    private void swap(int i1, int i2) {
        @SuppressWarnings("unchecked")
        T t = (T) array[i1];
        array[i1] = array[i2];
        array[i2] = t;
    }


    public String toString() {
        return subtreeToString(0);
    }

    private String subtreeToString(final int rootIndex) {
        if (rootIndex >= array.length) {
            return "_";
        }
        return String.format("( %s ( %s , %s )", (null == array[rootIndex]) ? "NULL" : array[rootIndex].toString(),
                subtreeToString(2 * rootIndex + 1), subtreeToString(2 * rootIndex + 2));
    }

}