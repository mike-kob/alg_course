

public class Test {
	public static void main(String[] args) {
		Fruit f1 = new Fruit("Banana", "Yellow", 120, 31);
		Fruit f2 = new Fruit("Apple", "Green", 100, 48);
		Fruit f3 = new Fruit("Orange", "Orange", 115, 24);
		Fruit f4 = new Fruit("Cherry", "Zed", 24, 4);
		Fruit f5 = new Fruit("Kiwi", "Brown", 56, 29);
		Fruit f6 = new Fruit("Cherry", "Red", 24, 9);

		Fruit[] fruits1 = Sorter.quickSortAsc(new Fruit[] { f1, f2, f3, f4 });
		Fruit[] fruits2 = Sorter.quickSortDesc(new Fruit[] { f6, f2, f2, f3, f5 });

		System.out.println("Quick sort without comparator ascending order for fruits1");
		for (Fruit fruit : fruits1) {
			System.out.println(fruit);
		}
		
		System.out.println("\nQuick sort without comparator descending order for fruits2");
		for (Fruit fruit : fruits2) {
			System.out.println(fruit);
		}
		
		Fruit[] fruits3 = Sorter.quickSortAsc(new Fruit[] { f1, f5, f3, f6, f4 },Fruit.BY_WEIGHT );
		Fruit[] fruits4 = Sorter.quickSortDesc(new Fruit[] { f6, f2, f1, f1, f5 }, Fruit.BY_COLOUR);

		System.out.println("\nQuick sort with comparator by weight ascending order for fruits3");
		for (Fruit fruit : fruits3) {
			System.out.println(fruit);
		}
		
		System.out.println("\nQuick sort with comparator by colour descending order for fruits4");
		for (Fruit fruit : fruits4) {
			System.out.println(fruit);
		}

		
		
		fruits1 = Sorter.mergeSortAsc(new Fruit[] { f2, f3, f4, f1 });
		fruits2 = Sorter.mergeSortDesc(new Fruit[] { f6, f3, f2, f6, f5 });

		System.out.println("\nMerge sort without comparator ascending order for fruits1");
		for (Fruit fruit : fruits1) {
			System.out.println(fruit);
		}
		
		System.out.println("\nMerge sort without comparator descending order for fruits2");
		for (Fruit fruit : fruits2) {
			System.out.println(fruit);
		}
		
		fruits3 = Sorter.mergeSortAsc(new Fruit[] { f1, f5, f3, f6, f4 },Fruit.BY_COLOUR );
		fruits4 = Sorter.mergeSortDesc(new Fruit[] { f5, f2, f2, f1, f5 }, Fruit.BY_WEIGHT);

		System.out.println("\nMerge sort with comparator by colour ascending order for fruits3");
		for (Fruit fruit : fruits3) {
			System.out.println(fruit);
		}
		
		System.out.println("\nMerge sort with comparator by weight descending order for fruits4");
		for (Fruit fruit : fruits4) {
			System.out.println(fruit);
		}
		
		fruits1 = Sorter.heapSortAsc(new Fruit[] { f2, f3, f6, f2, f5 });
		fruits2 = Sorter.heapSortDesc(new Fruit[] { f1, f2, f3, f4, f5 });

		System.out.println("\nHeap sort without comparator ascending order for fruits1");
		for (Fruit fruit : fruits1) {
			System.out.println(fruit);
		}
		
		System.out.println("\nHeap sort without comparator descending order for fruits2");
		for (Fruit fruit : fruits2) {
			System.out.println(fruit);
		}
		
		fruits3 = Sorter.heapSortAsc(new Fruit[] { f1, f3, f3, f6, f4 },Fruit.BY_COLOUR );
		fruits4 = Sorter.heapSortDesc(new Fruit[] { f5, f2, f2, f1, f5 }, Fruit.BY_WEIGHT);

		System.out.println("\nHeap sort with comparator by colour ascending order for fruits3");
		for (Fruit fruit : fruits3) {
			System.out.println(fruit);
		}
		
		System.out.println("\nHeap sort with comparator by weight descending order for fruits4");
		for (Fruit fruit : fruits4) {
			System.out.println(fruit);
		}
		
		
	}

}
