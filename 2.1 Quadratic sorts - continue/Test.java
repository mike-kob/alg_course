package homework;


public class Test {
	public static void main(String[] args) {
		Fruit f1 = new Fruit("Banana", "Yellow", 120, 31);
		Fruit f2 = new Fruit("Apple", "Green", 100, 48);
		Fruit f3 = new Fruit("Orange", "Orange", 115, 24);
		Fruit f4 = new Fruit("Cherry", "Red", 24, 4);
		Fruit f5 = new Fruit("Kiwi", "Brown", 56, 29);
		Fruit f6 = new Fruit("Cherry", "Red", 24, 9);
		
		Fruit[] fruits1 = Sorter.insertionSortDesc(new Fruit[] { f1, f3, f4, f6,f5 });
		Fruit[] fruits2 = Sorter.insertionSortDesc(new Fruit[] { f1, f2, f5, f4 }, Fruit.BY_NAME);
		Fruit[] fruits3 = Sorter.insertionSortAsc(new Fruit[] { f6, f6, f2, f2, f5, f5 });
		Fruit[] fruits4 = Sorter.insertionSortAsc(new Fruit[] { f2, f3, f1, f2, f1 }, Fruit.BY_COLOUR);
		
		System.out.println("Insertion sort without comparator, descending order, fruits1");
		for (Fruit fruit : fruits1) {
			System.out.println(fruit);
		}

		System.out.println("\nInsertion sort with comparator by name, descending order, fruits2");

		for (Fruit fruit : fruits2) {
			System.out.println(fruit);
		}

		System.out.println("\nInsertion sort without comparator, ascending order, fruits3");
		for (Fruit fruit : fruits3) {
			System.out.println(fruit);
		}

		System.out.println("\nInsertion sort with comparator by colour, ascending order, fruits4");

		for (Fruit fruit : fruits4) {
			System.out.println(fruit);
		}
		System.out.println("\n=====================================================================");

		
		fruits1 = Sorter.combSortDesc(new Fruit[] { f2, f5, f1, f3, f4 });
		fruits2 = Sorter.combSortDesc(new Fruit[] { f1, f2, f5, f4 }, Fruit.BY_COLOUR);
		fruits3 = Sorter.combSortAsc(new Fruit[] { f1, f1, f3, f4, f2, f6 });
		fruits4 = Sorter.combSortAsc(new Fruit[] { f2, f3, f1, f5, f6 }, Fruit.BY_NAME);

		System.out.println("\nComb sort without comparator, descending order, fruits1");
		for (Fruit fruit : fruits1) {
			System.out.println(fruit);
		}

		System.out.println("\nComb sort with comparator by colour, descending order, fruits2");

		for (Fruit fruit : fruits2) {
			System.out.println(fruit);
		}
		
		System.out.println("\nComb sort without comparator, ascending order, fruits3");
		for (Fruit fruit : fruits3) {
			System.out.println(fruit);
		}

		System.out.println("\nComb sort with comparator by name, ascending order, fruits4");

		for (Fruit fruit : fruits4) {
			System.out.println(fruit);
		}
		
System.out.println("\n=====================================================================");

		
		fruits1 = Sorter.shellSortDesc(new Fruit[] { f1, f1, f1, f3, f4 });
		fruits2 = Sorter.shellSortDesc(new Fruit[] { f1, f3, f5, f4 }, Fruit.BY_COLOUR);
		fruits3 = Sorter.shellSortAsc(new Fruit[] { f5, f1, f3, f4, f2, f6 });
		fruits4 = Sorter.shellSortAsc(new Fruit[] { f3, f1, f4, f6 }, Fruit.BY_WEIGHT);

		System.out.println("\nShell sort without comparator, descending order, fruits1");
		for (Fruit fruit : fruits1) {
			System.out.println(fruit);
		}

		System.out.println("\nShell sort with comparator by colour, descending order, fruits2");

		for (Fruit fruit : fruits2) {
			System.out.println(fruit);
		}
		
		System.out.println("\nShell sort without comparator, ascending order, fruits3");
		for (Fruit fruit : fruits3) {
			System.out.println(fruit);
		}

		System.out.println("\nShell sort with comparator by weight, ascending order, fruits4");

		for (Fruit fruit : fruits4) {
			System.out.println(fruit);
		}
		
		
	}
	
	
}
