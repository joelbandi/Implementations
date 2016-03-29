//URLify the string


public class URLify{
	public static void main(String[] args){

		System.out.println(solution(args[0],Integer.parseInt(args[1],10)));

	}

	public static String solution(String s, int length){
		int newlength,spaces;
		spaces=0;
		char[] newarr = new char[]{};

		char[] arr = s.toCharArray();
		

		for(int i=0;i<length;i++){
			if(arr[i]==' '){
				spaces++;
			}
		}

		newlength=length+spaces*2;
		newarr[newlength]='\0';
		for(int i=length-1; i>=0; i--){
			if (arr[i]==' '){
				newarr[newlength-1]='0';
				newarr[newlength-2]='2';
				newarr[newlength-3]='%';
				newlength-=3;
			}else{
				newarr[newlength-1]=arr[i];
				newlength--;
			}
		}


		return new String(newarr);


	}
}