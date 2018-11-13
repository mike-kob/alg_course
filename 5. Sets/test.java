package homework;

public class test {

	public static void main(String[] args) {
		List<Integer> set1 = new List<Integer>(9);
		set1.add(4);
		set1.add(-5);
		set1.add(-2);
		set1.add(1);
		set1.add(11);
		set1.add(18);
		
		List<Integer> set2 = new List<Integer>(1);
		set2.add(9);
		set2.add(4);
		set2.add(-2);
		System.out.println(set2);
				
		
		System.out.println(set1 );
		
		System.out.println("\nUnion: " + SetProcessor.union(set2, set1));
		System.out.println("Intersection: " + SetProcessor.intersection(set2, set1));
		System.out.println("Difference: " + SetProcessor.difference(set1, set2));
		
		System.out.println("Equal: " + SetProcessor.equal(set2, set1));
		
		SetProcessor.makeNull(set2);
		System.out.println("\nMakeNull (set1): " + set2);
		
		System.out.println("\nMember (-10 in set2): " + SetProcessor.member(-10, set1));
		System.out.println("Member (-2 in set2): " + SetProcessor.member(-2, set1));
		
		SetProcessor.insert(5, set1);
		System.out.println("Insert (5 in set2): " + set1);
		SetProcessor.delete(5, set1);
		System.out.println("Delete (5 from set2): " + set1);
		
		System.out.println("\nMin (set2): " + SetProcessor.min(set1));
		System.out.println("Max (set2): " + SetProcessor.max(set1));
		
		
	}

}
