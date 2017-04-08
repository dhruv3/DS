package graphs;

import java.util.ArrayList;

public class AdjacencyList {
	
	private ArrayList<Integer> vertices;
	private LinkedList[] edges;
	private int vertexCount = 0;
	
	public AdjacencyList(int vertexCount){
		this.vertexCount = vertexCount;
		vertices = new ArrayList<Integer>();
		edges = new LinkedList[vertexCount];
		for(int i = 0; i < this.vertexCount; i++){
			vertices.add(i);
			edges[i] = new LinkedList();
		}
	}
	
	public void addEdge(int src, int dst){
		int i = vertices.indexOf(src);
		int j = vertices.indexOf(dst);
		
		if(i != -1 || j != -1){
			edges[i].insertAtStart(new listNode(dst));
			edges[j].insertAtStart(new listNode(src));
		}
	}
	
}
