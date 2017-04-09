package graphs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class MainClass {
	
	public static AdjacencyListG4G g;
	
	public static void main(String[] args) {
		createGraph();
		Scanner inp =  new Scanner(System.in);
		System.out.println("Enter the traversal you want to run");
		System.out.println("1. DFS \n2. BFS \n3. Topological Sort");
		int choice = inp.nextInt();
		switch(choice){
			case 1:
				dfsTraversal(2);
				break;
			case 2:
				bfsTraversal(0);
				break;
			
		}
	}

	private static void bfsTraversal(int startVertex) {
		int totalVertex = g.vertexCount();
		boolean visited[] = new boolean[totalVertex];
		System.out.println("BFS traversal:");
		//create a queue and add startVertex
		Queue<Integer> bfsQueue = new ArrayDeque<Integer>();
		bfsQueue.add(startVertex);
		
		visited[startVertex] = true;
		
		while(!bfsQueue.isEmpty()){
			int data = bfsQueue.poll();
			System.out.print(data + "\t");
			
			//get the LL corresponding to our vertex
			//get the head and travel the LL
			LinkedList ll = g.getList(data);
			listNode temp = ll.getHead();
			while(temp != null){
				//add to queue iff node hasn't been visited
				if(visited[temp.getData()] == false){
					visited[temp.getData()] = true;
					bfsQueue.add(temp.getData());
				}
				temp = temp.getNode();
			}
		}
		
	}

	private static void dfsTraversal(int startVertex) {
		int totalVertex = g.vertexCount();
		boolean visited[] = new boolean[totalVertex];
		System.out.println("DFS traversal:");
		
		//loop added so as to ensure all the nodes are visited
		//if graph has disconnected comps then this for loop solves the issue
		for(int i = 0; i < totalVertex; i++){
			if(visited[i] == false)
				dfsUtil(startVertex, visited);
		}
	}

	private static void dfsUtil(int vertex, boolean[] visited) {
		//set boolean flag to true
		visited[vertex] = true;
		System.out.print(vertex + "\t");
		//get the LL corresponding to our vertex
		//get the head and travel the LL
		LinkedList ll = g.getList(vertex);
		listNode temp = ll.getHead();
		while(temp != null){
			int data = temp.getData();
			//if not visited, then call fn with updated visited array
			if(visited[data] == false){
				dfsUtil(data, visited);
			}
			temp = temp.getNode();
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

}
