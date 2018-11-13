package practice;

public class Tester {

	public static void main(String[] args) {
		ArrayBinaryHeap<Integer> h = new ArrayBinaryHeap<Integer>(true);
		System.out.println("Is empty? " + h.isEmpty());
		
		h.add(5);
		h.add(3);
		h.add(4);
		h.add(8);

		System.out.println("\nadding 5,3,4,8: " + h);
		
		System.out.println("contains 4: " + h.contains(4));
		
		System.out.println("\nSize:" + h.size());
		
		System.out.println("\nRemove: " + h.remove());
		System.out.println("After removing: " + h);
		
		try {
			h.add(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
