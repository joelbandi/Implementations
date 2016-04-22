import java.util.*;
public class MinimalTree{

	public static void main(String[] args){


		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11));
		Tree t = new Tree();
		System.out.println(arr.size()-1);
		solution(t,arr,0,arr.size()-1);
		t.inorderTraverse(t.root);
		

	}

	public static void solution(Tree t, ArrayList<Integer> arr, int min, int max){


		if(max/2==0 || max == min){
			t.add(arr.get(max));
			return;
		}



		t.add(arr.get(max/2).intValue());
		solution(t,arr,min,((max)/2-1));
		solution(t,arr,((max)/2),max);


	}
}