//Tower of Hanoi

class Hanoi {

	public static void main(String... args){


		solution(7,"SRC","AUX","DST",0);




	}

	public static void solution(int disc,String src,String aux,String dst,int count){
		if(disc>0){
			

			solution(disc-1,src,dst,aux,count);

			System.out.println("move disc "+ disc + " from "+ src + " to " + dst + "\tmove:"+ ++count);

			solution(disc-1,aux,src,dst,count);

		}

	}

//recursive ftw...


}