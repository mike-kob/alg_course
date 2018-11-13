

import java.util.ArrayList;
import strategies.*;

public class Test {
	public static void main(String[] args) {
		// Creat 6 different fruit s and make an array of them
		Fruit f1 = new Fruit("Banana", "Yellow", 120, 31);
		Fruit f2 = new Fruit("Apple", "Green", 100, 48);
		Fruit f3 = new Fruit("Orange", "Orange", 115, 24);
		Fruit f4 = new Fruit("Cherry", "Zed", 24, 4);
		Fruit f5 = new Fruit("Kiwi", "Brown", 56, 29);
		Fruit f6 = new Fruit("Cherry", "Red", 24, 9);

		Fruit[] fruits1 = new Fruit[] { f1, f2, f3, f4, f5, f6 };
		Fruit[] fruits2 = new Fruit[] { f3, f2, f1, f5};
		Fruit[] fruits3 = new Fruit[] { f2, f5, f4, f1, f6 };
		Fruit[] fruits4 = new Fruit[] { f4, f5, f3, f6, f2, f4 };

		// Create all possible sort sratages and put them into an arraylist

		ArrayList<SortStrategy<Fruit>> a = new ArrayList<>();
		a.add(new BubbleSortStrategy<Fruit>());
		a.add(new SelectionSortStrategy<Fruit>());
		a.add(new InsertionSortStrategy<Fruit>());
		a.add(new CombSortStrategy<Fruit>());
		a.add(new ShellSortStrategy<Fruit>());
		a.add(new MergeSortStrategy<Fruit>());
		a.add(new QuickSortStrategy<Fruit>());
		a.add(new HeapSortStrategy<Fruit>());

		Sorter<Fruit> fruitSorter;
		
		//Go through the array applying each time new sort strategy
		for (int i = 0; i < a.size(); i++) {
			String name = a.get(i).getStrategyName();

			fruitSorter = new Sorter<>(a.get(0));

			System.out.println(name + " in ascending order without comparator for fruits1:");
			fruits1 = fruitSorter.sortAsc(fruits1);
			for (Fruit fruit : fruits1) {
				System.out.println(fruit);
			}

			System.out.println("\n"+name + " in descending order without comparator for fruits2:");
			fruits2 = fruitSorter.sortDesc(fruits2);
			for (Fruit fruit : fruits2) {
				System.out.println(fruit);
			}
			
			System.out.println("\n"+name + " in ascending order with comparator by weight for fruits3:");
			fruits3 = fruitSorter.sortAsc(fruits3, Fruit.BY_WEIGHT);
			for (Fruit fruit : fruits3) {
				System.out.println(fruit);
			}

			System.out.println("\n"+name + " in descending order with by colour comparator for fruits4:");
			fruits4 = fruitSorter.sortDesc(fruits4, Fruit.BY_COLOUR);
			for (Fruit fruit : fruits4) {
				System.out.println(fruit);
			}
			
			System.out.println("=========================================================================================\n");
		}
	}

}
