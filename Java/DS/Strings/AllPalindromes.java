import java.util.*;
public class AllPalindromes{
	
	
	public static void main(String[] args){



		solution(args[0]);


	}

	public static HashMap getfreq(String s){
		HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
		for(int i =0; i<s.length(); i++){
			if(hm.containsKey(new Character(s.charAt(i)))){
				Integer val = new Integer(hm.get(new Character(s.charAt(i))));
				val++;
				hm.put(new Character(s.charAt(i)),new Integer(val));
			}else{
				hm.put(new Character(s.charAt(i)),new Integer(1));
			}
		}
		return hm;	
	}

	public static void solution(String s){

		HashMap<Character,Integer> hm = getfreq(s);

		Iterator iter = hm.entrySet().iterator();

			System.out.println();
		while(iter.hasNext()){
			Map.Entry pair = (Map.Entry)iter.next();
			System.out.println("Character '"+pair.getKey()+"' occurs "+pair.getValue()+" times.");
		}
			System.out.println();

	}
}