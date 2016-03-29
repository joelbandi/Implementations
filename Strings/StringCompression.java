public class StringCompression{
	public static void main(String[] args){

		System.out.println(solution(args[0]));

	}

	public static String solution(String a){
		int counter =1;
		
		if(a.length()==0){
			return "invalid input";
		}

		if(a.length()==1){
			return a;
		}

		StringBuilder sb = new StringBuilder();
		char thisChar = a.charAt(0);

		for(int i = 1; i< a.length();i++){

			if(a.charAt(i) == a.charAt(i-1)){
				counter++;
			}else{
				sb.append(a.charAt(i-1));
				sb.append(String.valueOf(counter));
				counter=1;
			}

			thisChar = a.charAt(i);

		}
				sb.append(thisChar);
				sb.append(String.valueOf(counter));
				System.out.println(a +" >vs< "+ sb.toString());
		return a.length()<= sb.toString().length() ? a : sb.toString();
	}
}