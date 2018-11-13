
public class Tester {

	public static void main(String[] args) {
		
		System.out.println("Coding abc: " + Coder.code("abc"));
		System.out.println("Coding cba: " + Coder.code("cba"));
		
		System.out.println("Decoding 010001000: " + Coder.decode("010001000"));

		Huffman h = new Huffman(new String [] {"a:0.12", "b:0.4", "c:0.15", "d:0.08", "e:0.25"});
		Huffman h2 = new Huffman(new String [] {"z:0.1", "w:0.2", "x:0.3", "y:0.4"});
		System.out.println("\nTree1: " + h.getTree());
		System.out.println("Tree2: " + h2.getTree());
		
	}

}
