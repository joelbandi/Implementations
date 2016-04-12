/**
 * GraphParse- A simple graph generator which parses a file containing an adjacency list
 * representation of a graph into the the memory of your program
 */
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class Graph{
	private Node root;
	private String type;
	private Graph graph;
	Graph(){
		this.root=null;
	}
	public void GraphParse(String s) throws IOException{
		FileReader fr = new FileReader(s);
		BufferedReader br = new BufferedReader(fr);
		this.type = br.readLine();
		String check;
		String[] parts;
		if(true){
			check = br.nextLine();
			while(check!= null){
				parts = check.split("->");
				Node a = new Node(String.valueOf(parts[0]));
				Node b = new Node(String.valueOf(parts[1]));
				add(a,b);
			}
		}
	}
	public void dfs(){
	}
	public void bfs(){
	}
	public void work(){
	}
	public boolean add(Node a,Node b) throws Exception{
		
	}
}
class Node {
	protected int i;
	protected char c;
	protected String s;
	protected boolean visited;
	protected ArrayList<Node> children;
	Node(int i) {
		this.i = i;
		this.c = '\0';
		this.s = null;
		this.visited = false;
		this.children = new ArrayList<Node>();
	}
	Node(char c) {
		this.i = 0;
		this.c = c;
		this.s = null;
		this.visited=false;
		this.children = new ArrayList<Node>();
	}
	Node(String s){
		this.i = 0;
		this.c = '\0';
		this.s = s;
		this.visited=false;
		this.children = new ArrayList<Node>();
	}
}