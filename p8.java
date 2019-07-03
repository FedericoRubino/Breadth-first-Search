/*
  Federico Rubino
  frubino
  Breadth First Search
  BFS
  p8.java
*/

import java.util.Scanner;
import java.util.ArrayList;


public class p8{

    public static void main(String args[]){
	Scanner input = new Scanner(System.in);
	String line = "";
	int length = 0;
	String temp[];
	ArrayList<Integer> maze = new ArrayList<Integer>();
	while(input.hasNextLine()){
	    line = input.nextLine().toLowerCase();;
	    temp = line.split("(?!^)");
	    for(int i = 0; i < line.length();i++){
		char c = line.charAt(i);
		if(c > 57){ // means that it is a lowercase letter
		    maze.add(c - 87); 
		} else {
		    maze.add(c - 48); //char number -> int number
		}
	    }
	}//while input
	if(line.length() > 0){
	    Graph g = new Graph(maze, line.length());
	    g.populateAdjList();
	    BFS shortestPath = new BFS(g, 0);
	    shortestPath.printPath();
	}
    }//end main
}//end class
