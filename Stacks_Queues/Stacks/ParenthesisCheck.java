import java.util.Stack;
public class ParenthesisCheck{
	public static void main(String[] params){


		String string1 = "";
		String string2 = "{{}{}}";
		String string3 = "{";
		String string4 = "}";
		String string5 = "{()}([]){}";

		System.out.println(solution(string1)); //true
		System.out.println(solution(string4)); //false
		System.out.println(solution(string5)); //true

		
	}


	public static boolean solution(String s){
		Stack<String> stack = new Stack<String>();

		if(s.length()==0){
			return true;
		}
		
		for(char c : s.toCharArray()){
			if(c=='{' || c== '(' || c == '['){

				stack.push(Character.toString(c));

			}else if (c=='}' || c== ')' || c == ']'){

				if(stack.empty()){
					return false;
				}
				if(stack.pop()!=Character.toString(c)){
					return false;
				}
			}
		}

		if(stack.empty()){
			return true;
		}else{
			return false;
		}

	}
}