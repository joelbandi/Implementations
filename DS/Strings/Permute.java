import java.util.*;
public class Permute{

	public static void main(String... params){


		for(String i : solution("abc")){
			System.out.println(i);
		}




	}

	
	public static ArrayList<String> solution(String word){

		// base case
		if(word.length() <= 1){
			return new ArrayList<String>(Arrays.asList(word));
		}

		// first we generate the list of 
		ArrayList<String> one = solution(word.substring(0,word.length()-1));
		
		ArrayList<String> two = new ArrayList<String>();
		for(String s : one){

			for(int i = 0; i < s.length() ; i++){
				
				if(i == 0){
					two.add(word.substring(word.length()-1)+s);
					continue;
				}
				
				two.add(s.substring(0,i)+word.substring(word.length()-1)+s.substring(i));
				

				if(i == s.length()){
					two.add(s+word.substring(word.length()-1));
					continue;
				}

			}
		}


		return two;
	}



}