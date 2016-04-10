//recursive

public class CommonPrefix{
	public static void main(String[] args){

		String ans = solution("1abcd123","abc456");
		System.out.println(ans);


	}

	public static String solution(String a,String b){


		if(a.length()==0 || b.length()==0){
			return "";
		}

		if(a.charAt(0)==b.charAt(0)){
			return a.charAt(0)+solution(a.substring(1),b.substring(1));
		}

		return "";
	}
}