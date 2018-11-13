

public class MyGraph{
	private DoubleList<DoubleList<Integer>> adjacencyList;

	public MyGraph(int[][] adjacencyMatrix) {
		for(int i = 0; i< adjacencyMatrix.length; i++) {
			if(adjacencyList == null) {
				adjacencyList = new DoubleList<DoubleList<Integer>>(getRow(adjacencyMatrix[i]));
			} else {
				adjacencyList.append(getRow(adjacencyMatrix[i]));
			}
		}
		
	}
	
	private DoubleList<Integer> getRow(int[] row) {
		DoubleList<Integer> listRow = null;
		
		for(int i = 0; i<row.length; i++) {
			if(listRow == null && row[i] == 1) {
				listRow = new DoubleList<Integer>(i);
			} else if (row[i] == 1) {
				listRow.append(i);
			}
		}
		return listRow;
	}
	
	public String toString() {
		String str = "";
		int i = 0;
		for(DoubleList<Integer> list:adjacencyList) {
			str+=  i + " --> " + list.toString() + ";\n";
			i++;
		}
		return str;
	}
	
}
