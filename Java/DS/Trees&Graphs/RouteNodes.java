import java.util.*;
public class RouteNodes{
	public static void main(String[] args){
		Graph g  = new Graph();
		g.addEdge("1","2");
		g.addEdge("2","3");
		g.addEdge("2","4");
		g.addEdge("3","5");
		g.addEdge("4","6");
		System.out.println(solution("1","2",g));
	}
	public static boolean solution(String a, String b, Graph g){
		if(a==b){
			return true;
		}else if(a==null || b==null){
			return false;
		}
		Stack<String> stack  = new Stack<String>();
		HashSet<String> hs = new HashSet<String>();
		stack.push(a);
		String k = a;
		while(!stack.isEmpty()){
			for(String s : g.getNeighbours(k)){
				if(s==b){
					return true;
				}else{
					if(!hs.contains(s)){
						stack.push(s);
					}			
				}
			}
			k = stack.pop();
			if(!hs.contains(k)){
				hs.add(k);
			}
		}
		return false;
	}
}