package practice;

public class Test {
	public static void main(String[] args) {
		Fruit f1 = new Fruit("Banana", "Yellow", 120, 23);
		Fruit f2 = new Fruit("Apple", "Green", 100, 15);
		Fruit f3 = new Fruit("Orange", "Orange", 115, 24);
		Fruit f4 = new Fruit("Cherry", "Red", 24, 9);
		Fruit f5 = new Fruit("Kiwi", "Brown", 56, 29);
		Fruit f6 = new Fruit("Cherry", "Red", 24, 9);

		Fruit[] fruits1 = Sorter.selectionSortDesc(new Fruit[] { f1, f2, f3, f4 });
		Fruit[] fruits2 = Sorter.selectionSortDesc(new Fruit[] { f1, f2, f5, f4 }, Fruit.BY_WEIGHT);
		Fruit[] fruits3 = Sorter.selectionSortAsc(new Fruit[] { f1, f6, f3, f4, f5, f6 });
		Fruit[] fruits4 = Sorter.selectionSortAsc(new Fruit[] { f2, f2, f1, f4, f6 }, Fruit.BY_COLOUR);

		System.out.println("Selection sort without comparator, descending order, fruits1");
		for (Fruit fruit : fruits1) {
			System.out.println(fruit);
		}

		System.out.println("\nSelection sort with comparator by weight, descending order, fruits2");

		for (Fruit fruit : fruits2) {
			System.out.println(fruit);
		}

		System.out.println("\nSelection sort without comparator, ascending order, fruits3");
		for (Fruit fruit : fruits3) {
			System.out.println(fruit);
		}

		System.out.println("\nSelection sort with comparator by colour, ascending order, fruits4");

		for (Fruit fruit : fruits4) {
			System.out.println(fruit);
		}
		System.out.println("\n=====================================================================");

		fruits1 = Sorter.bubbleSortDesc(new Fruit[] { f2, f5, f1, f3, f4 });
		fruits2 = Sorter.bubbleSortDesc(new Fruit[] { f1, f2, f5, f4 }, Fruit.BY_WEIGHT);
		fruits3 = Sorter.bubbleSortAsc(new Fruit[] { f1, f1, f3, f4, f2, f6 });
		fruits4 = Sorter.bubbleSortAsc(new Fruit[] { f2, f3, f1, f5, f6 }, Fruit.BY_NAME);

		System.out.println("\nBubble sort without comparator, descending order, fruits1");
		for (Fruit fruit : fruits1) {
			System.out.println(fruit);
		}

		System.out.println("\nBubble sort with comparator by weight, descending order, fruits2");

		for (Fruit fruit : fruits2) {
			System.out.println(fruit);
		}
		
		System.out.println("\nBubble sort without comparator, ascending order, fruits3");
		for (Fruit fruit : fruits3) {
			System.out.println(fruit);
		}

		System.out.println("\nBubble sort with comparator by name, ascending order, fruits4");

		for (Fruit fruit : fruits4) {
			System.out.println(fruit);
		}

	}

}
