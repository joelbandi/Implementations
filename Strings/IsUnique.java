// check whether string has duplicate characters
import java.util.HashMap;
import java.util.Arrays;
public class IsUnique{
	public static void main(String arg[]){
		System.out.println("IsUnique");
				

		System.out.println(solution2(arg[0]));
		System.out.println(solution2(arg[1]));
		System.out.println(solution2(arg[2]));
		System.out.println(solution2(arg[3]));



	}

	static public boolean solution1(String s){
		//using hashmap datastructure
		HashMap hm = new HashMap();
		if(s.length() >128)return false;

		for(char c : s.toCharArray()){
			
			if(hm.containsKey(c)) return false;

   			hm.put(c,c);
		}

		return true;
	}

	static public boolean solution2(String s){
		//sort the array and check for consecutive characters whether theyre same or not
		if(s.length() >128)return false;



		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		for(int i = 0; i+1<s.length();i++){
			if(arr[i+1]==arr[i]){
				return false;
			}
		}
		return true;

	}
}