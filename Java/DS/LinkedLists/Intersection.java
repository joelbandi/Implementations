// Im going to use the officially given LinkedList in the collection api.

// To use the locally written version in the file node.
// just use Node mylist = new Node(); and use the mylist.append(integer method);


// but for now let's use the Official LinkedList


import java.util.*;

public class Intersection{


	public static void main(String[] args){

		LinkedList<Integer> first = new LinkedList<Integer>();
		LinkedList<Integer> second = new LinkedList<Integer>();


		for(int i = 0; i<= 3; i++){

			second.add(new Integer(i));
		}

		for(int i = 4; i<= 9; i++){
			first.add(new Integer(i));
			second.add(new Integer(i));
		}


		Integer result = solution(first,second);


		System.out.println(result.toString());


	}

	public static Integer solution(LinkedList<Integer> first, LinkedList<Integer> second){

		int firstlength = first.size();
		int secondlength = second.size();



		int difference;
		ListIterator<Integer> firstiter;
		ListIterator<Integer> seconditer;


		if(firstlength > secondlength){

			difference = firstlength - secondlength;
			firstiter = first.listIterator(difference);
			seconditer = second.listIterator(0);

		}else if(firstlength < secondlength){

			difference = secondlength - firstlength;
			firstiter = first.listIterator(0);
			seconditer = second.listIterator(difference);

		}else{

			firstiter = first.listIterator(0);
			seconditer = second.listIterator(0);

		}

		while(firstiter.hasNext()){

			if(firstiter.next().equals(seconditer.next()))
			{
				return firstiter.previous();
			}



		}

		return null;


	}

}