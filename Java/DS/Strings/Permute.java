import java.util.*;
public class Permute{

	public static void main(String... params){


		for(String i : solution(params[0])){
			System.out.println(i);
		}




	}

	
	public static ArrayList<String> solution(String word){

		ArrayList<String> result = new ArrayList<String>();


		if(word.length() == 1){
			result.add(word);
			return result;
		}

		int lastIndex = word.length()-1;
		String lastChar = word.substring(lastIndex);
		String remaining = word.substring(0,lastIndex);


		result = merge(solution(remaining),lastChar);


		return result;


	}


	public static ArrayList<String> merge(ArrayList<String> arr, String c){

		ArrayList<String> res = new ArrayList<String>();

		for(String s : arr){

			for(int i = 0 ; i <= s.length() ; i++){

				String ins = new StringBuffer(s).insert(i,c).toString();
				res.add(ins);

			}

		}

		return res;


	}







}