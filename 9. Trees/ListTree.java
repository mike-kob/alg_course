

import java.util.NoSuchElementException;

public class ListTree<T> implements MyTree<T> {

	public static class Element<Q> {
		private Q value;

		public void setValue(Q value) {
			this.value = value;
		}

		private Element<Q> parent;
		private Element<Q> left;
		private Element<Q> right;

		public void setLeft(Element<Q> left) {
			this.left = left;
		}

		public void setRight(Element<Q> right) {
			this.right = right;
		}

		public Element(Q value) {
			this.value = value;
		}

		public void setParent(Element<Q> p) {
			this.parent = p;
		}

		public Element<Q> getParent() {
			return parent;
		}

		public Element<Q> getLeft() {
			return left;
		}

		public Element<Q> getRight() {
			return right;
		}

		public Q getValue() {
			return value;
		}

		@SuppressWarnings("unused")
		public boolean equals(Element<Q> el) {
			if (el == null) {
				return false;
			}

			if ((el.value == null) && (this.value == null)) {
				return true;
			}

			if ((el.value == null) || (this.value == null)) {
				return false;
			}

			return (el.value.equals(this.value));
		}
	}

	private Element<T> data;

	public void setData(Element<T> data) {
		this.data = data;
	}

	private int size;

	public ListTree(final T rootElement) {
		data = new Element<T>(rootElement);
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

	public Element<T> getData() {
		return data;
	}

	@Override
	public void addValue(T newValue, T fatherValue, boolean isAddingAsLeftSon) {

		/*
		 * if (null == newValue) { throw new NullPointerException(); }
		 */

		if (null != getElementByValue(data, newValue)) {
			throw new SecurityException();
		}

		Element<T> fatherElement = getElementByValue(data, fatherValue);
		if (null == fatherElement) {
			throw new NoSuchElementException();
		}

		if (isAddingAsLeftSon) {
			if (null == fatherElement.left) {
				fatherElement.left = new Element<>(newValue);
				fatherElement.left.parent = fatherElement;
				size++;
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			if (null == fatherElement.right) {
				fatherElement.right = new Element<>(newValue);
				fatherElement.right.parent = fatherElement;
				size++;
			} else {
				throw new IllegalArgumentException();
			}
		}
	}

	public Element<T> getElementByValue(final Element<T> head, final T value) {
		if (null == head || null == head.getValue()) {
			return null;
		}

		if (head.getValue().equals(value)) {
			return head;
		}

		Element<T> leftSearchResult = getElementByValue(head.left, value);
		return (null != leftSearchResult ? leftSearchResult : getElementByValue(head.right, value));
	}

	@Override
	public String toString() {
		return subtreeToString(data);
	}

	private String subtreeToString(final Element<T> rootElement) {
		if (null == rootElement) {
			return "NULL";
		}
		return String.format("( %s ( %s, %s )",
				(null == rootElement.getValue()) ? "NULL" : rootElement.getValue().toString(),
				subtreeToString(rootElement.left), subtreeToString(rootElement.right));
	}

	@Override
	public void removeValue(T value) {
		Element<T> el = getElementByValue(data, value);

		if (value == null) {
			throw new NullPointerException();
		}
		if (el == null) {
			throw new NoSuchElementException();
		}

		Element<T> parent = el.parent;
		if (parent == null) {
			Element<T> copy = data.right;
			data = data.left;
			Element<T> last = data;

			while (last.left != null) {
				last = last.left;
			}
			last.left = copy;
			last.left.parent = last;
			return;
		}

		if (parent.left == el) {
			if (el.left == null && el.right == null) {
				parent.left = null;
				return;
			}
			if (el.left != null && el.right == null) {
				parent.left = el.left;
				return;
			}
			if (el.left == null && el.right != null) {
				parent.left = el.right;
				return;
			}

			Element<T> copy = el.right;
			parent.left = el.left;
			Element<T> last = el;
			while (last.left != null) {
				last = last.left;
			}
			last.left = copy;
			last.left.parent = last;

		} else {
			if (el.left == null && el.right == null) {
				parent.right = null;
				return;
			}
			if (el.left != null && el.right == null) {
				parent.right = el.left;
				return;
			}
			if (el.left == null && el.right != null) {
				parent.right = el.right;
				return;
			}

			Element<T> copy = el.right;
			parent.right = el.left;
			Element<T> last = el;
			while (last.left != null) {
				last = last.left;
			}
			last.left = copy;
			last.left.parent = last;
		}

	}

}
