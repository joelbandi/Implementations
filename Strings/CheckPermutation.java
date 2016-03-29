public class CheckPermutation{
	public static void main(String[] args){


		if(args.length<2){
			System.out.println("Atleast two args needed");
			return;
		}

		System.out.println(solution(args[0],args[1])); 	
	}

	public static boolean solution(String one,String two){
		if(one.length()!=two.length()){
			return false;
		}

		char[] oneArray = one.toCharArray();
		char[] twoArray = two.toCharArray();

		java.util.Arrays.sort(oneArray);
		java.util.Arrays.sort(twoArray);




		return java.util.Arrays.equals(oneArray,twoArray);

	}
}