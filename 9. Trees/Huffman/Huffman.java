package homework;

import java.util.Arrays;

import ListTree;
import ListTree.Element;

public class Huffman {
	private Letter[] alphabet;

	private class Letter implements Comparable<Letter> {
		double probability;
		String value;

		public Letter(String val, String prob) {
			value = val;
			probability = new Double(prob);
		}

		public String toString() {
			return value + "-" + probability;
		}

		@Override
		public int compareTo(Letter l2) {
			if (this.probability < l2.probability) {
				return -1;
			} else if (this.probability > l2.probability) {
				return 1;
			}
			return 0;
		}

		public Letter add(Letter other) {
			return new Letter(this.value + other.value, String.valueOf(this.probability + other.probability));
		}
	}

	public Huffman(String[] alphabet) {
		Letter[] array = new Letter[alphabet.length];
		for (int i = 0; i < alphabet.length; i++) {
			String[] ar = alphabet[i].split(":");
			array[i] = new Letter(ar[0], ar[1]);
		}
		this.alphabet = array;
	}

	public ListTree<String> getTree() {
		double prob = 0;
		
		Arrays.sort(alphabet);
		Letter first = alphabet[0].add(alphabet[1]);

		ListTree<String> tree = new ListTree<String>(first.value);
		tree.addValue(alphabet[0].value, first.value, true);
		tree.addValue(alphabet[1].value, first.value, false);
		alphabet[0] = new Letter("", String.valueOf(2.0 + prob));
		alphabet[1] = first;

		while (prob < 1) {
			Arrays.sort(alphabet);
			first = alphabet[0].add(alphabet[1]);
			prob = first.probability;
			Element<String> root = new Element<String>(first.value);

			root.setLeft(new Element<String>(alphabet[0].value));
			root.setRight(tree.getData());
			tree.setData(root);

			alphabet[0] = new Letter("", String.valueOf(2.0 + prob));
			alphabet[1] = first;
		}

		return tree;
	}
}
