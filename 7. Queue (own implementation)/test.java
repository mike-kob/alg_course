

public class test {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>();
		System.out.println("Is queue empty? " + q.empty());

		try {
			q.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			q.add(4);
			q.add(5);
			q.add(6);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println("Current queue: " + q);
			System.out.println("\nelement:" + q.element());
			System.out.println("Current queue: " + q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("Current queue: " + q);
			System.out.println("\nRemove:" + q.remove());
			System.out.println("Current queue: " + q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\nPolling element: " + q.poll());
		System.out.println("Current queue: " + q);

		System.out.println("\nPeeking element: " + q.peek());
		System.out.println("Current queue: " + q);

		System.out.println("Searching element 7: " + q.search(7));

		try {
			System.out.println("\nOffering element 78: " + q.offer(78));
			System.out.println("Current queue: " + q);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
