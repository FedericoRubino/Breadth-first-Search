/*
  Federico Rubino
  frubino
  Breadth first search
  Assignment #8
  Graph.java
*/

import java.util.ArrayList;


public class Graph{

    //constructor
    public Graph(){size = twoDim = 0; maze = null; adjList = null;}

    //constructor
    //populates: size, twoDim, maze and adjList
    public Graph(ArrayList<Integer> m, int size){
	this.size = size;
	twoDim = size * size;
	maze = m;
	for(int i = 0; i < twoDim; i++){
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    adjList.add(temp);
	}
    }

    //This is a long function that first checks for adjacency of rooms
    //and then checks if the adjacent rooms are connected
    //this function uses many concepts and formulas from Assignment #6
    public void populateAdjList(){
	int room;
	int[] roomValue = new int[4];
	int[] roomID;
	for(int i = 0; i < twoDim; i++){
	    roomID = new int[]{-1,-1,-1,-1};
	    room = maze.get(i);
	    //0 = right, 1=bottom, 2=left, 3=top
	    //checks right
	    if((i + 1) % size != 0){ 
		roomValue[0] = maze.get(i + 1);
		roomID[0] = i + 1; 
	    }
	    //checks bottom
	    if(i < (twoDim - size)){ 
		roomValue[1] = maze.get(i + size);
		roomID[1] = i + size; 
	    }
	    //checks left
	    if(i % size != 0){ 
		roomValue[2] = maze.get(i-1);
		roomID[2] = i - 1; 
	    }
	    //checks top
	    if(i >= size){ 
		roomValue[3] = maze.get(i - size);
		roomID[3] = i - size; 
	    }

	    //0 = right, 1=bottom, 2=left, 3=top
	    boolean noWall = true;
	    if(roomID[0] != -1){
		for(int k = 0; k < 8; k++){
		    if(room == right[k]||roomValue[0] == left[k]) 
			noWall = false;
		}
		if(noWall)
		    adjList.get(i).add(roomID[0]);
		noWall = true;
	    }
	    if(roomID[1] != -1){
		for(int k = 0; k < 8; k++){
		    if(room == bottom[k]||roomValue[1] == top[k]) 
			noWall = false;
		}
		if(noWall)
		    adjList.get(i).add(roomID[1]);
		noWall = true;
	    }
	    if(roomID[2] != -1){
		for(int k = 0; k < 8; k++){
		    if(room == left[k]||roomValue[2] == right[k]) 
			noWall = false;
		}
		if(noWall)
		    adjList.get(i).add(roomID[2]);
		noWall = true;
	    }
	    noWall = true;
	    if(roomID[3] != -1){
		for(int k = 0; k < 8; k++){ //8 is the length of the wall arrays
		    if(room == top[k]||roomValue[3] == bottom[k]) 
			noWall = false;
		}
		if(noWall)
		    adjList.get(i).add(roomID[3]);
		noWall = true;
	    }
	}
    }//end of function 

    //returns the two dimensional size of the maze
    public int getSize(){
	return twoDim;
    }

    //returns the Adjacency list
    public ArrayList<ArrayList<Integer>> getAdjList(){
	return adjList;
    }

    //member variables
    private ArrayList<Integer> maze;
    private int size;
    private int twoDim;
    private ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

    //check to see that they don't have these values/walls
    //wall arrays:
    private int[] right = new int[]{1,3,5,7,9,11,13,15};
    private int[] left = new int[]{4,5,6,7,12,13,14,15};
    private int[] top = new int[]{8,9,10,11,12,13,14,15};
    private int[] bottom = new int[]{2,3,6,7,10,11,14,15};

}//end of Graph
