import java.util.Scanner;
public class RecursiveReverse{
	public static void main(String[] Args){

		Scanner inp = new Scanner(System.in);

		System.out.print("Enter String: ");
		String string = inp.nextLine();
		System.out.println(solution(string));



	}


	public static String solution(String string){
		
		if(string.length()==0){
			return string;
		}

		return (solution(string.substring(1))+string.charAt(0));
	}

}