package homework;

import ListTree;
import ListTree.Element;

public class Coder {
	private static ListTree<String> codingTree;

	public static void init() {
		codingTree = new ListTree<String>("");

		codingTree.addValue("abcd", "", true);
		codingTree.addValue("efgh", "", false);

		codingTree.addValue("ab", "abcd", true);
		codingTree.addValue("cd", "abcd", false);
		codingTree.addValue("ef", "efgh", true);
		codingTree.addValue("gh", "efgh", false);

		codingTree.addValue("a", "ab", true);
		codingTree.addValue("b", "ab", false);
		codingTree.addValue("c", "cd", true);
		codingTree.addValue("d", "cd", false);
		codingTree.addValue("e", "ef", true);
		codingTree.addValue("f", "ef", false);
		codingTree.addValue("g", "gh", true);
		codingTree.addValue("h", "gh", false);
	}

	public static String code(String in) {
		init();
		String code = "";
		for (int i = 0; i < in.length(); i++) {
			String ch = in.charAt(i) + "";
			Element<String> root = codingTree.getData();
			while (!root.getValue().equals(ch)) {
				if (root.getLeft().getValue().contains(ch)) {
					root = root.getLeft();
					code += "0";
				} else {
					root = root.getRight();
					code += "1";
				}
			}
		}
		return code;

	}

	public static String decode(String in) {
		init();
		String decode = "";
		Element<String> root = codingTree.getData();

		for (int i = 0; i < in.length(); i++) {

			String ch = in.charAt(i) + "";

			if (root.getLeft() != null || root.getRight() != null) {
				if (ch.equals("0")) {
					root = root.getLeft();
				} else {
					root = root.getRight();
				}
			}
			if (root.getLeft() == null && root.getRight() == null) {
				decode += root.getValue();
				root = codingTree.getData();
			}
		}
		return decode;

	}

}
