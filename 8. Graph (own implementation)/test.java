

public class test {
	static int[][] textM = {{0,1,0,0,0,0,1,0,1,0},
							{1,0,0,0,1,0,1,0,0,1},
							{0,0,0,0,1,0,1,0,0,0},
							{0,0,0,0,1,1,0,0,1,0},
							{0,1,1,1,0,1,0,0,0,1},
							{0,0,0,1,1,0,0,0,0,0},
							{1,1,1,0,0,0,0,0,0,0},
							{0,0,0,0,0,0,0,0,1,1},
							{1,0,0,1,0,0,0,1,0,0},
							{0,1,0,0,1,0,0,1,0,0}
							};
	
	public static void main(String[] args) {
		
		MyGraph g = new MyGraph(textM);
		System.out.println(g);
	}

}
