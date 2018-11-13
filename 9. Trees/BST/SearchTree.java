package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import homework.ListTree.Element;

public class SearchTree<T extends Comparable<T>> {
	private ListTree<T> tree;

	public SearchTree() {
		tree = new ListTree<T>(null);
	}

	// ---------------homework part -----------------------
	public T remove(T elem) {
		if (elem == null) {
			throw new NullPointerException();
		}

		if (!contains(elem)) {
			throw new IllegalArgumentException();
		}

		Element<T> root = tree.getData();
		root = deleteRec(root, elem);

		return elem;
	}

	private Element<T> deleteRec(Element<T> root, T value) {
		if (root == null)
			return root;

		if (value.compareTo(root.getValue()) < 0) {
			root.setLeft(deleteRec(root.getLeft(), value));
		} else if (value.compareTo(root.getValue()) > 0) {
			root.setRight(deleteRec(root.getRight(), value));
		} else {
			if (root.getLeft() == null)
				return root.getRight();
			else if (root.getRight() == null)
				return root.getLeft();

			root.setValue(minValue(root.getRight()));
			root.setRight(deleteRec(root.getRight(), root.getValue()));
		}
		return root;
	}

	private T minValue(Element<T> root) {
		T minv = root.getValue();
		while (root.getLeft() != null) {
			minv = root.getLeft().getValue();
			root = root.getLeft();
		}
		return minv;
	}

	public List<T> getElementsAsc() {
		if(tree == null)
			throw new NullPointerException();
		List<T> list = new ArrayList<T>();
		getElements(tree.getData(), list);
		return list;
	}

	public List<T> getElementsDecs() {
		if (tree == null)
			throw new NullPointerException();
		List<T> list = getElementsAsc();
		Collections.reverse(list);
		return list;
	}

	private void getElements(Element<T> node, List<T> list) {
		if (node == null)
			return;
		
		getElements(node.getLeft(), list);
		list.add(node.getValue());
		getElements(node.getRight(), list);
	}

	// ---------------practice part -----------------------
	public boolean isEmpty() {
		return tree.getData().getValue()==null;
	}

	public boolean contains(T elem) {
		if (elem == null) {
			throw new NullPointerException();
		}
		if (tree == null) {
			return false;
		}

		if (tree.getElementByValue(tree.getData(), elem) == null) {
			return false;
		} else {
			return true;
		}

	}

	public void add(T elem) {
		if (elem == null) {
			throw new NullPointerException();
		}
		if (contains(elem)) {
			throw new IllegalArgumentException();
		}
		if (tree.getData().getValue() == null) {
			tree.setData(new Element<T>(elem));
			return;
		}

		Element<T> curr = tree.getData();

		while (curr.getLeft() != null || curr.getRight() != null) {
			if (curr.getValue().compareTo(elem) > 0) {
				if (curr.getLeft() == null)
					break;
				curr = curr.getLeft();
			} else {
				if (curr.getRight() == null)
					break;
				curr = curr.getRight();
			}
		}
		if (curr.getValue().compareTo(elem) > 0) {
			tree.addValue(elem, curr.getValue(), true);
		} else {
			tree.addValue(elem, curr.getValue(), false);
		}

	}

	public String toString() {
		return tree.toString();
	}
}
