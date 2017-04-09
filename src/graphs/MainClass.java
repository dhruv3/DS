package graphs;

import java.util.Scanner;

public class MainClass {
	
	public static AdjacencyListG4G g;
	
	public static void main(String[] args) {
		createGraph();
		Scanner inp =  new Scanner(System.in);
		System.out.println("Enter the traversal you want to run");
		System.out.println("1. DFS \n 2.BFS \n 3. Topological Sort");
		int choice = inp.nextInt();
		switch(choice){
			case 1:
				dfsTraversal(2);
				break;
			
		}
	}

	private static void createGraph() {
		g = new AdjacencyListG4G(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
	}

	private static void dfsTraversal(int startVertex) {
		int totalVertex = g.vertexCount();
		boolean visited[] = new boolean[totalVertex];
		System.out.println("DFS traversal:");
		for(int i = 0; i < totalVertex; i++){
			if(visited[i] == false)
				dfsUtil(startVertex, visited);
		}
	}

	private static void dfsUtil(int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.print(vertex + "\t");
		
		LinkedList ll = g.getList(vertex);
		listNode temp = ll.getHead();
		while(temp != null){
			temp = temp.getNode();
			int data = temp.getData();
			if(visited[data] == false){
				dfsUtil(data, visited);
			}
		}
	}

}
