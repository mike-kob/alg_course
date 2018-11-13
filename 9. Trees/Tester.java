

public class Tester {

	public static void main(String[] args) {
		System.out.println("======Array Tree======");
		ArrayTree<Integer> at = new ArrayTree<>(1, 2);

		at.addValue(2, 1, true);
		at.addValue(3, 1, false);

		at.addValue(4, 2, true);
		at.addValue(5, 2, false);

		at.addValue(6, 3, true);
		at.addValue(7, 3, false);

		System.out.println(at);

		at.removeValue(4);
		try {
			at.removeValue(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(at);

		
		
		System.out.println("\n\n======Linked Tree======");
		ListTree<Integer> lt = new ListTree<>(1);

		lt.addValue(2, 1, true);
		lt.addValue(3, 1, false);

		lt.addValue(4, 2, true);
		lt.addValue(5, 2, false);

		lt.addValue(6, 3, true);
		lt.addValue(7, 3, false);

		System.out.println(lt.toString());

		lt.removeValue(5);
		try {
			lt.removeValue(30);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(lt);
	}
}
