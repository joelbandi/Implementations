public class GrDriver{

	public static void main(String[] args){

		Graph g = new Graph();

		g.addEdge("0","1");
		g.addEdge("0","2");
		g.addEdge("1","2");
		g.addEdge("3","4");
		g.addEdge("2","6");
		g.addEdge("1","6");
		g.addEdge("4","5");
		g.addEdge("5","6");

		g.DFS("0",(s) -> System.out.println(s));

	}

}