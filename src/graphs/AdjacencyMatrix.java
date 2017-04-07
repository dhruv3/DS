package graphs;

public class AdjacencyMatrix {
	private boolean adjMat[][];
	private int vertexCount;
	
	public AdjacencyMatrix(int vertexCount){
		this.vertexCount = vertexCount;
		adjMat = new boolean[vertexCount][vertexCount];
	}
	
	public void addEdge(int i, int j){
		if(i<0 && j<0 && i>=vertexCount && j>=vertexCount)
			return;
		
		adjMat[i][j] = true;
		adjMat[j][i] = true;
	}
	
	public void removeEdge(int i, int j){
		if(i<0 && j<0 && i>=vertexCount && j>=vertexCount)
			return;
		
		adjMat[i][j] = false;
		adjMat[j][i] = false;
	}
	
	public boolean isEdge(int i, int j){
		if(i<0 && j<0 && i>=vertexCount && j>=vertexCount)
			return false;
		
		if(adjMat[i][j] = true)
			return true;
		return false;
	}

}
