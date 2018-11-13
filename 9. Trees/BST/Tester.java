package homework;

public class Tester {

	public static void main(String[] args) {
		SearchTree<Integer> st = new SearchTree<>();

		System.out.println("isEmpty: " + st.isEmpty());
		st.add(3);
		st.add(9);
		st.add(1);
		st.add(5);
		st.add(15);
		st.add(-9);
		
		System.out.println("\nAdd 3,9,1,5,15,-9: " + st);
		System.out.println("List with ascending order: " + st.getElementsAsc());
		
		st.remove(3);
		System.out.println("\nRemove 3:" + st);
		System.out.println("List with descending order: " + st.getElementsDecs());
		
		

		System.out.println("\nisEmpty: " + st.isEmpty());

	}
}
