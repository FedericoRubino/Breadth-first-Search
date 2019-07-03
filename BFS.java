/*
  Federico Rubino
  frubino
  Breadth first search
  Assignment #8
  BFS.java
*/

import java.util.PriorityQueue;
import java.util.ArrayList;


//Breadth first Search class
//used to find the shortest path in a maze
//constructor recieves paramaters class Graph and the starting point
//Graph class has size, and the adjacency list, which are essential
//for making this work
public class BFS{

    //constructor/ initialization
    public BFS(Graph g, int s){
	graphLength = g.getSize();
	ArrayList<ArrayList<Integer>> adjList = g.getAdjList();
	Q = new PriorityQueue<Integer>();
	color = new String[graphLength];
	d = new int[graphLength];
	p = new int[graphLength];
	for(int u = 1; u < graphLength; u++){ 
	    color[u] = "white"; // undiscovered
	    d[u] = Integer.MAX_VALUE; //distance = infinity
	    p[u] = -1; //no parent
	}
	color[s] = "gray";
	d[s] = 0;
	p[s] = -1;
	Q.add(s);
	while(Q.peek() != null){
	    int t = Q.peek(); // peek == front
	    ArrayList<Integer> adjTo = adjList.get(t);
	    for(int v = 0; v < adjTo.size(); v++){
		int l = adjTo.get(v);
		if(color[l] == "white"){
		    color[l] = "gray";
		    Q.add(l);
		    d[l] = d[t] + 1;
		    p[l] = t;
		}//if
	    }//for
	    color[t] = "black";
	    Q.remove(t);//deque
	}//while
    }

    //this function changes the array of path index's
    // into the coresponding coordinates
    public void printPath(){
	findPath(graphLength - 1);
	int oneDim = (int)Math.sqrt(graphLength);
	int x;
	int y;
	for(int i = path.size() - 1; i >= 0; i--){
	    x = path.get(i) % oneDim; 
	    y = (int)(path.get(i) / oneDim);
	    System.out.println("(" + x + ", " + y + ")");
	}
    }

    //finds the shortest path by finding all of the parents starting
    //with the final room in the maze
    //path will be in reverse order here
    private void findPath(int child){
	while(child >= 0 && child < graphLength){
	    path.add(child);
	    child = p[child];
	}
    }

    //member variables
    private int graphLength;
    private String[] color;//discovered or undiscovered
    private int[] d;//distance
    private int[] p;//parent
    private PriorityQueue<Integer> Q;
    private ArrayList<Integer> path = new ArrayList<Integer>();

}//end class
